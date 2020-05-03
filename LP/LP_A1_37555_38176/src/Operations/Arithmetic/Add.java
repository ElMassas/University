package Operations.Arithmetic;

import Operations.Operations;
import TISC.Machine;

public class Add extends ArithmeticOperations{

    private final int PC_JP = 4; //4 bytes

    @Override
    public void execute(Machine machine, String operator){
        //changes the values in the evaluation stack
<<<<<<< HEAD
        int t1 = machine.getEvaluationStack().pop();
        int t2 = machine.getEvaluationStack().pop();
        machine.getEvaluationStack().push(t1 operator t2);
        machine.changePC(4); //4 bytes
=======
        super.loadValues(machine);
        super.setValues(machine,this.t1 + this.t2 );
        machine.changePC(PC_JP);
>>>>>>> 844e986e34ce106b9cece845898615bf56afe67b
    }

    public void ex

}
