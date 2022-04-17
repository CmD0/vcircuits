package ca.vcircuits.gates;

public class XOrGate extends Gate {
    private OrGate or = new OrGate();
    private NAndGate nand = new NAndGate();
    private AndGate and = new AndGate();

    public XOrGate() {}


    public XOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        or.setA(a);
        nand.setA(a);
        update();
    }

    public void setB(boolean b) {
        or.setB(b);
        nand.setB(b);
        update();
    }

    @Override
    protected void update() {
        and.setA(or.isOn());
        and.setB(nand.isOn());

        o = and.isOn();
    }
}
