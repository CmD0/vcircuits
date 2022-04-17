package ca.vcircuits.gates;

public class NAndGate extends Gate {
    private NotGate not = new NotGate();
    private AndGate and = new AndGate();

    public NAndGate() {}

    public NAndGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    
    public void setA(boolean a) {
        and.setA(a);
        update();
    }

    public void setB(boolean b) {
        and.setB(b);
        update();
    }

    @Override
    protected void update() {
        not.setA(and.isOn());
        o = not.isOn();
    }
}
