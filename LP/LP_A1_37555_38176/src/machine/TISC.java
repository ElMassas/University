package machine;

import java.util.*;

import machine.operations.Operations;

public class TISC {

  // Machine Variables
  private ArrayList<Operations> operationsList;
  private Map<String, Integer> labelsPc;

  private Stack<Integer> evaluationStack;
  private BlockActivationLog executionStack;

  private int pc, ep;
  private int returnAdress;

  // Aux Variables
  private List<Integer> auxArgs;

  // Constructor
  public TISC() {
    operationsList = new ArrayList<Operations>();
    labelsPc = new Hashtable<String, Integer>();
    evaluationStack = new Stack<Integer>();
    executionStack = new BlockActivationLog();
  }

  /* Methods */

  // Machine
  public void setOperationsList(ArrayList<Operations> operationsList) {
    this.operationsList = operationsList;
  }

  public int getPc() {
    return pc;
  }

  public void setPc(int p) {
    this.pc = p;
  }

  public int getEp() {
    return ep;
  }

  public void setEp(int ep) {
    this.ep = ep;
  }

  public void changePC(int value) {
    this.pc += value;
  }

  public void addOperation(Operations op) {
    this.operationsList.add(op);
  }

  // Execution Stack
  private BlockActivationLog getExecutionStack() {
    return this.executionStack;
  }

  private void setExecutionStack(BlockActivationLog top) {
    this.executionStack = top;
  }

  // Lables
  public void addLable(String name) {
    this.labelsPc.put(name, this.operationsList.size());
  }

  public int getAdrByLable(String name) {
    return this.labelsPc.get(name);
  }

  // Arguments
  public void addArgument(int n, int val) {
    this.auxArgs.add(n, val);
  }

  public int getArgument(int n) {
    return this.auxArgs.get(n);
  }

  // Functions
  public void callFunction(String name) {
    this.setExecutionStack(new FunctionActivationLog(this.getExecutionStack(), new LinkedList<>(), this.auxArgs));
    this.setPc(this.labelsPc.get(name));
    this.auxArgs = new LinkedList<>();
  }

  public void checkFunctionLocals(int a, int l) throws Exception {
    FunctionActivationLog funclog = (FunctionActivationLog) this.executionStack;
    if (funclog.getArgumentsSize() != a)
      throw new Exception("Invalid ArgumentSize at ");
  }

  // Executes the TISC program loaded on the machine
  public void run() {
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

  // Operations functions
  public BlockActivationLog getActivationlogByDepth(int depth) {
    BlockActivationLog temp = executionStack;
    for (; depth > 0; depth--)
      temp = temp.getControlLink();
    return temp;
  }

  public int pop() {
    return this.evaluationStack.pop();
  }

  public void push(int val) {
    this.evaluationStack.push(val);
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