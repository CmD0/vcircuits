package ca.vcircuits;

public class Output {
    private boolean on = false;

    public Output() {}

    public Output(boolean on) {
        this.on = on;
    }
    
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
