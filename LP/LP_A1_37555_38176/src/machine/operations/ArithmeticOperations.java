package machine.operations;

import machine.TISC;

public abstract class ArithmeticOperations extends Operations {

    public int t1, t2;

    public void loadValues(TISC TISC) {
        this.t2 = TISC.pop();
        this.t1 = TISC.pop();
    }

    public void setValues(TISC TISC, int t3) {
        TISC.push(t3);
    }

}
