package ca.vcircuits.gates;

public class XOrGate implements Gate {
    private OrGate or = new OrGate();
    private NAndGate nand = new NAndGate();
    private AndGate and = new AndGate();

    private boolean o = false;

    public XOrGate() {}

    public XOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        or.setA(a);
        nand.setA(a);
    }

    public void setB(boolean b) {
        or.setB(b);
        nand.setB(b);
    }

    @Override
    public void update() {
        and.setA(or.isOn());
        and.setB(nand.isOn());

        o = and.isOn();
    }


    @Override
    public boolean isOn() {
        return o;
    }
}
