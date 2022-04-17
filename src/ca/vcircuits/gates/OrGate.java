package ca.vcircuits.gates;

public class OrGate extends Gate{
    
    private boolean a = false;
    private boolean b = false;

    public OrGate() {}

    public OrGate(boolean a, boolean b) {
        setA(a);
        setB(b);
    }

    public void setA(boolean a) {
        this.a = a;
        update();
    }

    public void setB(boolean b) {
        this.b = b;
        update();
    }

    @Override
    protected void update() {
        o = a || b;
    }
}
