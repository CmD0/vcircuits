package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.NotGate;

public class Decoder implements Circuit {

    // A simple decoder that takes in a 2 bit value and outputs through the appropriate output i.e. a value of 1(var1:1 var2:0) will turn on out1
    // while a value of 3 (var1:1 var2:1) will turn on out3
    // var1 represents the first digit of the 2bit value
    // var2 represents the second digit of the 2bit value
    // out1, out2, out3 and out4 represent 1, 2, 3 and 4 respectively

    private Input var1 = new Input();
    private Input var2 = new Input();

    private NotGate notVar1 = new NotGate();
    private NotGate notVar2 = new NotGate();

    private AndGate andOut1 = new AndGate();
    private AndGate andOut2 = new AndGate();
    private AndGate andOut3 = new AndGate();
    private AndGate andOut4 = new AndGate();

    private Output out1 = new Output();
    private Output out2 = new Output();
    private Output out3 = new Output();
    private Output out4 = new Output();

    public Decoder() {}

    public Decoder(boolean var1, boolean var2) {
        setVar1(var1);
        setVar2(var2);
    }

    public void setVar1(boolean var1) {
        this.var1.setOn(var1);
    }

    public void setVar2(boolean var2) {
        this.var2.setOn(var2);
    }

    public boolean getOut1() {
        return out1.isOn();
    }

    public boolean getOut2() {
        return out2.isOn();
    }

    public boolean getOut3() {
        return out3.isOn();
    }

    public boolean getOut4() {
        return out4.isOn();
    }

    @Override
    public void update() {
        
        notVar1.setA(var1.isOn());
        notVar2.setA(var2.isOn());
        
        andOut1.setA(notVar1.isOn());
        andOut1.setB(notVar2.isOn());
        out1.setOn(andOut1.isOn());

        andOut2.setA(notVar2.isOn());
        andOut2.setB(var1.isOn());
        out2.setOn(andOut2.isOn());

        andOut3.setA(notVar1.isOn());
        andOut3.setB(var2.isOn());
        out3.setOn(andOut3.isOn());

        andOut4.setA(var1.isOn());
        andOut4.setB(var2.isOn());
        out4.setOn(andOut4.isOn());

    }
    
}
