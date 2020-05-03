package Operations.Arithmetic;

import Operations.Operations;
import TISC.Machine;

public class Add extends Operations {

    @Override
    public void execute(Machine machine, String operator){
        //changes the values in the evaluation stack
        int t1 = machine.getEvaluationStack().pop();
        int t2 = machine.getEvaluationStack().pop();
        machine.getEvaluationStack().push(t1 operator t2);
        machine.changePC(4); //4 bytes
    }

    public void ex

}
