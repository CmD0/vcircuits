package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.OrGate;
import ca.vcircuits.gates.XOrGate;

public class FullAdder1B {
    private Input a;
    private Input b;
    private Input carryIn;

    private XOrGate addAB = new XOrGate();
    private XOrGate addCarry = new XOrGate();
    private AndGate abCarry = new AndGate();
    private AndGate sumAndCarry = new AndGate();
    private OrGate carryOrCarry = new OrGate();
    
    private Output sum = new Output();
    private Output carryOut = new Output();

    public FullAdder1B(boolean a, boolean b, boolean cin) {
        setA(a);
        setB(b);
        setCarryIn(cin);
    }


    public void setA(boolean a) {
        this.a.setStatus(a);
        update();
    }

    public void setB(boolean b) {
        this.b.setStatus(b);
        update();
    }

    public void setCarryIn(boolean cin) {
        carryIn.setStatus(cin);
        update();
    }


    private void update() {
        
    }
}
