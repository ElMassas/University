package machine.operations;

import machine.TISC;

public class Add extends ArithmeticOperations {

    @Override
    public void execute(TISC TISC) {
        super.loadValues(TISC);
        super.setValues(TISC, this.t1 + this.t2);
    }
}
