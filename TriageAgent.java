import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class TriageAgent extends Agent {
    protected void setup() {
        System.out.println("Triage Agent is ready to assess symptoms.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent().toLowerCase();
                    ACLMessage forward = new ACLMessage(ACLMessage.INFORM);
                    forward.addReceiver(new AID("Scheduler", AID.ISLOCALNAME));

                    // Autonomous Decision Logic
                    if (content.contains("chest pain") || content.contains("breathing")) {
                        forward.setContent("PRIORITY: CRITICAL");
                        System.out.println("Triage Decision: Emergency detected!");
                    } else {
                        forward.setContent("PRIORITY: ROUTINE");
                        System.out.println("Triage Decision: Routine check-up.");
                    }
                    send(forward);
                } else {
                    block();
                }
            }
        });
    }
}