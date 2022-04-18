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
        addAB.setA(a.getStatus());
        addAB.setB(b.getStatus());

        addCarry.setA(addAB.isOn());
        addCarry.setB(carryIn.getStatus());

        abCarry.setA(a.getStatus());
        abCarry.setB(b.getStatus());

        sumAndCarry.setA(addAB.isOn());
        sumAndCarry.setB(carryIn.getStatus());

        carryOrCarry.setA(abCarry.isOn());
        carryOrCarry.setB(sumAndCarry.isOn());

        sum.setStatus(addCarry.isOn());
        carryOut.setStatus(carryOrCarry.isOn());
    }

    public boolean getSum() {
        return sum.getStatus();
    }

    public boolean getCarryOut() {
        return sum.getStatus();
    }
}
