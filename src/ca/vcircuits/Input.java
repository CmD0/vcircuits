package ca.vcircuits;

public class Input {
    private boolean on = false;

    public Input() {}

    public Input(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
