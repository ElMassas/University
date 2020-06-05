package machine.operations;

import machine.TISC;

public class Exp extends ArithmeticOperations {
    @Override
    public void execute(TISC TISC) {
        super.loadValues(TISC);
        super.setValues(TISC, (int) Math.pow(this.t1, this.t2));
    }
}
