package Operations.Arithmetic;

import Operations.Operations;
import TISC.Machine;

public abstract class ArithmeticOperations extends Operations {

    public int t1, t2;

    public void loadValues(Machine machine){
        this.t1 = machine.getEvaluationStack().pop();
        this.t2 = machine.getEvaluationStack().pop();
    }

    public void setValues(Machine machine, int t3){
        machine.getEvaluationStack().push(t3);
    }

}
