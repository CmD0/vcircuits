package ca.vcircuits.gates;

public class NXOrGate implements Gate {
    private NotGate not = new NotGate();
    private XOrGate xor = new XOrGate();

    private boolean o = false;

    public NXOrGate() {}

    public NXOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    private void setA(boolean a) {
        xor.setA(a);
    }

    private void setB(boolean b) {
        xor.setB(b);
    }

    @Override
    public void update() {
        not.setA(xor.isOn());
        o = not.isOn();
    }

    @Override
    public boolean isOn() {
        return o;
    }
}
