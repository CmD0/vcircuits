package ca.vcircuits;

public class Output {
    private boolean status = false;

    public Output() {}

    public Output(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
