import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SchedulerAgent extends Agent {
    private boolean doctorBooked = true; // Simulating a full schedule

    protected void setup() {
        System.out.println("Scheduler/Negotiator Agent is active.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    if (msg.getContent().equals("PRIORITY: CRITICAL") && doctorBooked) {
                        System.out.println("Schedule full! Starting negotiation to swap slots...");
                        
                        // Interaction: Real Negotiation
                        ACLMessage negotiate = new ACLMessage(ACLMessage.PROPOSE);
                        // In a real scenario, you'd search for routine patients via DF
                        negotiate.setContent("SWAP_OFFER: 20% discount for moving your slot?");
                        System.out.println("Negotiator: Proposal sent to routine patients.");
                    }
                } else {
                    block();
                }
            }
        });
    }
}