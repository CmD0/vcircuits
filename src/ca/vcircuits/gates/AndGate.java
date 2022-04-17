package ca.vcircuits.gates;

public class AndGate extends Gate {
    
    private boolean a = false;
    private boolean b = false;

    public AndGate() {
    }

    public AndGate(boolean a, boolean b) {
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
        o = a && b;
    }
}
