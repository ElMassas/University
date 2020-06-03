package machine;

import java.util.*;

import machine.operations.Operations;

public class TISC {

  // Machine Variables
  private ArrayList<Operations> operationsList;
  private Map<String, Integer> labelsPc;

  private Stack<Integer> evaluationStack;
  private Stack<Integer> executionStack;

  private int pc, ep;
  private int returnAdress;

  // Constructor
  public TISC() {
    operationsList = new ArrayList<Operations>();
    labelsPc = new Hashtable<String, Integer>();
    evaluationStack = new Stack<Integer>();
    executionStack = new Stack<Integer>();
  }

  /* Methods */
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

  public void changePC(int value) {
    this.pc += value;
  }

  public void addOperation(Operations op) {
    this.operationsList.add(op);
  }

  public void addLable(String name) {
    this.labelsPc.put(name, this.operationsList.size());
  }

  // Executes the TISC program loaded on the machine
  public void execute() {
    /*
     * this.setPc("program");//programs always starts with program this.returnAdress
     * = pc + 1; while(!executionStack.empty()){
     * operationsList.get(pc).execute(this); }
     */
  }

  public String operationsToBeDone() {
    String outcome = "";

    for (int i = 0; i < operationsList.size(); i++) {
      outcome += (operationsList.getClass().getName() + "|\t");
    }

    return outcome;
  }

  // UI functions
  public void printOperationsList() {
    System.out.println("->OperationsList<-");
    int c = 0;
    for (Operations op : this.operationsList) {
      System.out.printf("[%4d]:", c);
      System.out.println(op.getClass().getName());
      c++;
    }
  }

  public void printLabels() {
    System.out.println("->LableList<-");
    int c = 0;
    for (Map.Entry<String, Integer> entry : this.labelsPc.entrySet()) {
      int i = (Integer) entry.getValue();
      System.out.printf("[%4d]:%s->pos:%d->inst:%s\n", c, (String) entry.getKey(), i,
          this.operationsList.get(i).getClass().getName());
      c++;
    }

  }

}