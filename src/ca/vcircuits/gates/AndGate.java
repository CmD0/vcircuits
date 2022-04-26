package ca.vcircuits.gates;

public class AndGate implements Gate {
    
    private boolean a = false;
    private boolean b = false;
    private boolean o = false;

    public AndGate() {
    }

    public AndGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public void update() {
        o = a && b;
    }

    @Override
    public boolean isOn() {
        return o;
    }
}
