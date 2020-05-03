package Operations.Arithmetic;

import Operations.Operations;
import TISC.Machine;

public class Add extends ArithmeticOperations{

    private final int PC_JP = 4; //4 bytes

    @Override
    public void execute(Machine machine) {
        super.loadValues(machine);
        super.setValues(machine,this.t1 + this.t2 );
        machine.changePC(PC_JP);
    }
}
