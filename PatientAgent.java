import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

public class PatientAgent extends Agent {
    protected void setup() {
        System.out.println("Patient " + getLocalName() + " is online.");
        
        // Initial request to Triage
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("Triage", AID.ISLOCALNAME));
        msg.setContent("Symptom: chest pain, Duration: 2 hours");
        send(msg);
        System.out.println(getLocalName() + " sent symptoms to Triage.");
    }
}