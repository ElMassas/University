package Operations.Arithmetic;

import Operations.Operations;
import TISC.Machine;

public class Add extends Operations {
    public String operationType(){ return "ADD";}

    public void execute(Machine machine){
        //changes the values in the evaluation stack
        int t1 = machine.getEvaluationStack().pop();
        int t2 = machine.getEvaluationStack().pop();
        machine.getEvaluationStack().push(t1 + t2);
        machine.changePC();
    }

}
