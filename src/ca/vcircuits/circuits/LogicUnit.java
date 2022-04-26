package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.NotGate;
import ca.vcircuits.gates.OrGate;

//This is an exmaple implementation a of a simple logic unit being able to comput NOT A,  A OR B and A AND B
public class LogicUnit implements Circuit {
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
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        //change the satus of the input
        this.a.setOn(a);
    }

    public void setB(boolean b) {
        //change the status of the input
        this.b.setOn(b);
    }

    //public methods to retrieve the outputs

    public boolean getNotOut() {
        return notOut.isOn();
    }

    public boolean getOrOut() {
        return orOut.isOn();
    }

    public boolean getAndOut() {
        return andOut.isOn();
    }

    @Override
    public void update() {
        //update the not gate
        not.setA(a.isOn());
        
        //update the or gate
        or.setA(a.isOn());
        or.setB(b.isOn());
        
        //update the and gate
        and.setA(a.isOn());
        and.setB(b.isOn());
        
        //update the outputs
        notOut.setOn(not.isOn());
        orOut.setOn(or.isOn());
        andOut.setOn(and.isOn());
    }

}
