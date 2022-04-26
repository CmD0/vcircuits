package ca.vcircuits.gates;

public class NotGate implements Gate {
    
    private boolean a = false;

    private boolean o = false;


    public NotGate() {
    }

    public NotGate(boolean a) {
        setA(a);
    }

    public void setA(boolean a) {
        this.a = a;
    }

    @Override
    public void update() {
        o = !a;
    }

    @Override
    public boolean isOn() {
        return o;
    }

}
