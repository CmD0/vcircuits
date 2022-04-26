package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.OrGate;
import ca.vcircuits.gates.XOrGate;

public class FullAdder1B implements Circuit {
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

    public FullAdder1B() {}

    public FullAdder1B(boolean a, boolean b, boolean cin) {
        setA(a);
        setB(b);
        setCarryIn(cin);
    }

    public void setA(boolean a) {
        this.a.setOn(a);
    }

    public void setB(boolean b) {
        this.b.setOn(b);
    }

    public void setCarryIn(boolean cin) {
        carryIn.setOn(cin);
    }

    public boolean getSum() {
        return sum.isOn();
    }

    public boolean getCarryOut() {
        return sum.isOn();
    }

    public void update() {
        addAB.setA(a.isOn());
        addAB.setB(b.isOn());

        addCarry.setA(addAB.isOn());
        addCarry.setB(carryIn.isOn());

        abCarry.setA(a.isOn());
        abCarry.setB(b.isOn());

        sumAndCarry.setA(addAB.isOn());
        sumAndCarry.setB(carryIn.isOn());

        carryOrCarry.setA(abCarry.isOn());
        carryOrCarry.setB(sumAndCarry.isOn());

        sum.setOn(addCarry.isOn());
        carryOut.setOn(carryOrCarry.isOn());
    }
}
