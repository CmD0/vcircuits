package ca.vcircuits.gates;

public class NotGate extends Gate {
    
    protected boolean a = false;

    public NotGate() {
    }

    public NotGate(boolean a) {
        setA(a);
    }

    public void setA(boolean a) {
        this.a = a;
        update();
    }

    @Override
    protected void update() {
        o = !a;
    }

}
