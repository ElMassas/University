package TISC;

import Operations.Operations;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Stack;

public class Machine {

    ArrayList<Operations> operationsList;
    Dictionary<String, Integer> labelsPc;
    Stack<Integer> evaluationStack;
    Stack<Integer> executionStack;
    int pc, ep;
    public int returnAdress;


    public Machine() {
    }

    public ArrayList<Operations> getOperationsList() {
        return (ArrayList<Operations>) operationsList;
    }

    public void setOperationsList(ArrayList<Operations> operationsList) {
        this.operationsList = operationsList;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(String label) {
        labelsPc.put(label, this.pc);
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public Stack<Integer> getEvaluationStack() {
        return evaluationStack;
    }

    public void setEvaluationStack(Stack<Integer> evaluationStack) {
        this.evaluationStack = evaluationStack;
    }

    public Stack<Integer> getExecutionStack() {
        return executionStack;
    }

    public void setExecutionStack(Stack<Integer> executionStack) {
        this.executionStack = executionStack;
    }

    public void changePC(){ this.pc += 1; }

    //Executes the TISC program loaded on the machine
    public void execute(){
        this.setPc("program");//programs always starts with program
        this.returnAdress = pc + 1;
        while(!executionStack.empty()){
            operationsList.get(pc).execute(this);
        }
    }

    public String operationsToBeDone(){
        String outcome = "";

        for(int i = 0; i < operationsList.size(); i ++){
            outcome += (operationsList.get(i).toString() + "|\t");
        }

        return  outcome;
    }

}
