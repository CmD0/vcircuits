package ca.vcircuits;

public class Input {
    private boolean status = false;

    public Input() {}

    public Input(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
