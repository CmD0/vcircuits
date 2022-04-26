package ca.vcircuits.gates;

public class NOrGate implements Gate {
    private NotGate not = new NotGate();
    private OrGate or = new OrGate();

    private boolean o = false;

    public NOrGate() {}

    public NOrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        or.setA(a);
    }

    public void setB(boolean b) {
        or.setB(b);
    }

    @Override
    public void update() {
        not.setA(or.isOn());
        o = not.isOn();
    }

    @Override
    public boolean isOn() {
        return o;
    }
}