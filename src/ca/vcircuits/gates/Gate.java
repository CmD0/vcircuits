package ca.vcircuits.gates;

public abstract class Gate {
    
    protected boolean o = false;

    public Gate() {

    }

    public boolean isOn() {
        return o;
    }
    
    protected abstract void update();
}
