public abstract class ArithmeticOperations extends Operations {

    public int t1, t2;

    public void loadValues(TISC TISC){
        this.t1 = TISC.getEvaluationStack().pop();
        this.t2 = TISC.getEvaluationStack().pop();
    }

    public void setValues(TISC TISC, int t3){
        TISC.getEvaluationStack().push(t3);
    }

}
