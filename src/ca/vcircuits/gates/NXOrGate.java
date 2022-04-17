package ca.vcircuits.gates;

public class NXOrGate extends Gate {
    private NotGate not = new NotGate();
    private XOrGate xor = new XOrGate();

    public NXOrGate() {}

    public NXOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    private void setA(boolean a) {
    }

    private void setB(boolean b) {
    }

    @Override
    protected void update() {
        not.setA(xor.isOn());
        o = not.isOn();
    }
}
