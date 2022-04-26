package ca.vcircuits.gates;

public class NAndGate implements Gate {
    private NotGate not = new NotGate();
    private AndGate and = new AndGate();

    private boolean o;

    public NAndGate() {}

    public NAndGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    
    public void setA(boolean a) {
        and.setA(a);
    }

    public void setB(boolean b) {
        and.setB(b);
    }

    @Override
    public void update() {
        not.setA(and.isOn());
        o = not.isOn();
    }

    @Override
    public boolean isOn() {
        
        return o;
    }
}
