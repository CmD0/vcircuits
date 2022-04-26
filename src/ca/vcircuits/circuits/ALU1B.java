package ca.vcircuits.circuits;

import ca.vcircuits.Input;
import ca.vcircuits.Output;
import ca.vcircuits.gates.AndGate;
import ca.vcircuits.gates.XOrGate;

public class ALU1B implements Circuit{

    //1 bit ALU capable of computing NotA, A OR B, A AND B, and do full 1 bit addition on A, B and CarryIn using the 2bit value set with code1 and code2

    private Input a = new Input();
    private Input b = new Input();
    private Input cin = new Input();
    private Input code1 = new Input();
    private Input code2 = new Input();

    private Decoder decoder;
    private LogicUnit logic;
    private FullAdder1B adder;

    private AndGate selectNot = new AndGate();
    private AndGate selectOr = new AndGate();
    private AndGate selectAnd = new AndGate();
    private AndGate selectAdd = new AndGate();

    private XOrGate xorNotOr = new XOrGate();
    private XOrGate xorAndAdd = new XOrGate();
    private XOrGate xorOut = new XOrGate();

    private Output output = new Output();
    private Output cout = new Output();

    public ALU1B() {}

    public ALU1B(boolean a, boolean b, boolean cin, boolean code1, boolean code2) {
        setA(a);
        setB(b);
        setCarryIn(cin);
        setCode1(code1);
        setCode2(code2);
    }

    public void setA(boolean a) {
        this.a.setOn(a);
    }

    public void setB(boolean b) {
        this.b.setOn(b);
    }

    public void setCarryIn(boolean cin) {
        this.cin.setOn(cin);
    }

    public void setCode1(boolean code1) {
        this.code1.setOn(code1);
    }

    public void setCode2(boolean code2) {
        this.code2.setOn(code2);
    }

    public boolean getOutput() {
        return output.isOn();
    }

    public boolean getCarryOut() {
        return cout.isOn();
    }

    @Override
    public void update() {
        //set the circuits
        decoder = new Decoder(code1.isOn(), code2.isOn());
        logic = new LogicUnit(a.isOn(), b.isOn());
        adder = new FullAdder1B(a.isOn(), b.isOn(), cin.isOn());

        //update the circuits
        decoder.update();
        logic.update();
        adder.update();

        //set the decoder's outputs to the selector and gates
        selectNot.setA(decoder.getOut1());
        selectOr.setA(decoder.getOut2());
        selectAnd.setA(decoder.getOut3());
        selectAdd.setA(decoder.getOut4());

        //set the logic unit and adder's outputs to the selector and gates
        selectNot.setB(logic.getNotOut());
        selectOr.setB(logic.getOrOut());
        selectAnd.setB(logic.getAndOut());
        selectAdd.setB(adder.getSum());

        //determine which value to output
        xorNotOr.setA(selectNot.isOn());
        xorNotOr.setB(selectOr.isOn());
        xorAndAdd.setA(selectAnd.isOn());
        xorAndAdd.setB(selectAdd.isOn());
        xorOut.setA(xorNotOr.isOn());
        xorOut.setB(xorAndAdd.isOn());

        //set the outputs
        output.setOn(xorOut.isOn());
        cout.setOn(adder.getCarryOut());

    }
    
}
