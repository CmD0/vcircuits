package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.NotGate;
import ca.vcircuits.gates.OrGate;

//This is an exmaple implementation a of a simple logic unit being able to comput NOT A,  A OR B and A AND B
public class LogicUnit {
    //defining input nodes
    private Input a = new Input();
    private Input b = new Input();

    //defining the gates that will be used
    private NotGate not = new NotGate();
    private OrGate or = new OrGate();
    private AndGate and = new AndGate();

    //defining the output nodes
    private Output notOut = new Output();
    private Output orOut = new Output();
    private Output andOut = new Output();

    //constructor that has a boolean parameter per input(in this case only 2)
    public LogicUnit(boolean a, boolean b) {
        //assign the inputs
        setA(a);;
        setB(b);;
    }

    public void setA(boolean a) {
        //change the satus of the input
        this.a.setStatus(a);;
        //update the circuit
        update();
    }

    public void setB(boolean b) {
        //change the status of the input
        this.b.setStatus(b);;
        //update the circuit
        update();
    }

    private void update() {
        //update the not gate
        not.setA(a.getStatus());
        
        //update the or gate
        or.setA(a.getStatus());
        or.setB(b.getStatus());
        
        //update the and gate
        and.setA(a.getStatus());
        and.setB(b.getStatus());
        
        //update the outputs
        notOut.setStatus(not.isOn());
        orOut.setStatus(or.isOn());
        andOut.setStatus(and.isOn());
    }

    //public methods to retrieve the outputs

    public Output getNotOut() {
        return notOut;
    }

    public Output getOrOut() {
        return orOut;
    }

    public Output getAndOut() {
        return andOut;
    }

}
