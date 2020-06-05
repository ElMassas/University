package machine.operations;

import machine.*;

public class Mod extends ArithmeticOperations {
    @Override
    public void execute(TISC TISC) {
        super.loadValues(TISC);
        super.setValues(TISC, this.t1 % this.t2);
    }

}
