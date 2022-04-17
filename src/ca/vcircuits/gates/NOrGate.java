package ca.vcircuits.gates;

public class NOrGate extends Gate {
    private NotGate not = new NotGate();
    private OrGate or = new OrGate();

    public NOrGate() {}

    public NOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        or.setA(a);
        update();
    }

    public void setB(boolean b) {
        or.setB(b);
        update();
    }

    @Override
    protected void update() {
        not.setA(or.isOn());
        o = not.isOn();
    }
}