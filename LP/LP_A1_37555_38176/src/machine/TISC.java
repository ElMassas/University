package machine;

import java.util.*;

import machine.operations.*;
import machine.activationlogs.*;

public class TISC {

  // Machine Variables
  private ArrayList<Operations> operationsList;
  private Map<String, Integer> labelsPc;

  private Stack<Integer> evaluationStack;
  private ActivationLog executionStack;

  private int pc;
  private int ep;

  // Aux Variables
  private List<Integer> auxArgs;
  private List<String> entryOrder;
  public boolean end;

  // Constructor
  public TISC() {
    operationsList = new ArrayList<Operations>();
    labelsPc = new Hashtable<String, Integer>();
    evaluationStack = new Stack<Integer>();
    executionStack = new BlockActivationLog();

    this.auxArgs = new LinkedList<>();
    this.entryOrder = new LinkedList<>();
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
    return this.ep;
  }

  public void setEp(int ep) {
    this.ep = ep;
  }

  public void addOperation(Operations op) {
    this.operationsList.add(op);
  }

  // Execution Stack
  public ActivationLog getExecutionStack() {
    return this.executionStack;
  }

  public void setExecutionStack(ActivationLog top) {
    this.executionStack = top;
  }

  public int getDepth(ActivationLog al) {
    int depth = 0;
    ActivationLog temp = this.executionStack;

    while (temp != null) {
      if (temp == al) {
        return depth;
      }
      temp = temp.getControlLink();
      depth++;
    }
    return -1;
  }

  // Temp Arguments
  public List<Integer> getArguments() {
    return this.auxArgs;
  }

  public void cleanArguments() {
    this.auxArgs = new LinkedList<>();
  }

  public void addArgument(int n, int val) {
    this.auxArgs.add(n - 1, val);
  }

  // Lables
  public void addLable(String name) {
    this.labelsPc.put(name, this.operationsList.size());
    this.entryOrder.add(name);
  }

  public int getAdrByLable(String name) {
    return this.labelsPc.get(name);
  }

  // Executes the TISC program loaded on the machine
  public void run() {
    // Prep for run
    // Set program to start on the program lable
    this.pc = this.getAdrByLable("program");

    // So the program doesnt end on start
    this.end = false;

    // Program enviroment
    FunctionDeclarationActivationLog temp;
    // Seek all lables by entry order
    for (String name : this.entryOrder) {
      // Get the lable pointer
      int pointer = this.labelsPc.get(name);
      // Separate normal lables fromfunction lables
      Operations op = this.operationsList.get(pointer);
      if (op instanceof Locals) {

        Locals lop = (Locals) op;
        // Create Activation log for the function declaration and link the control link
        // and a accsses link to the current enviroment
        temp = new FunctionDeclarationActivationLog(this.executionStack, this.executionStack, name, pointer, lop.getA(),
            lop.getV());
        // set the new Activation log to the top of the stack
        this.executionStack = temp;
      }
    }
    // Sets enviroment to start on the program enviroment
    this.ep = entryOrder.indexOf("program");

    // Find Program Scope depth
    ActivationLog temp2 = this.executionStack;
    int i = 0;
    while (temp2 != null) {
      if (temp2 instanceof FunctionDeclarationActivationLog)
        if (((FunctionDeclarationActivationLog) temp2).getName().compareTo("program") == 0) {
          this.setEp(i);
          break;
        }
      temp2 = temp2.getControlLink();
      i++;
    }

    // Mock program runner //

    try {
      // Call program function
      (new Call("0", "program")).execute(this);

      // Debuging
      this.printFDActivationLogs();
      this.printOperationsList();
      this.printLabels();
      System.out.println("RUN:");

      while (!this.end) {
        System.out.printf("[RUN]:%s\n", this.operationsList.get(this.pc).getClass().getName());
        this.operationsList.get(this.pc).execute(this);
        this.printFDActivationLogs();
        this.pc++;
      }
    } catch (ExecutionException e) {
      e.printExecutionException();
      System.out.println("* Compiler Traceback");
      e.printStackTrace();
    }

  }

  public String operationsToBeDone() {
    String outcome = "";

    for (int i = 0; i < operationsList.size(); i++) {
      outcome += (operationsList.getClass().getName() + "|\t");
    }

    return outcome;
  }

  // Machine stack operations
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

  // Testing methods ->To remove<-
  public void printFDActivationLogs() {
    ActivationLog temp = this.executionStack;
    System.out.println("->FDA Reversed<-");
    int c = 0;
    while (temp != null) {
      if (c == this.ep)
        System.out.print("[->]:");
      else
        System.out.printf("[%2d]:", c);
      c++;

      System.out.print(temp.getClass().getName() + ":");

      if (temp instanceof FunctionDeclarationActivationLog) {
        FunctionDeclarationActivationLog temp2 = (FunctionDeclarationActivationLog) temp;
        System.out.printf(" Name %s, ArgSize %d, LocSize %d ", temp2.getName(), temp2.maxArgs, temp2.maxLocals);
      }
      if (temp instanceof BlockActivationLog) {
        BlockActivationLog temp2 = (BlockActivationLog) temp;
        System.out.print(" Variable size " + temp2.localVariables.length);
      }
      if (temp instanceof FunctionActivationLog) {
        FunctionActivationLog temp2 = (FunctionActivationLog) temp;
        System.out.print(" Argument size " + temp2.getArgumentsSize());
      }

      System.out.println();
      temp = temp.getControlLink();
    }
    System.out.println("Enviroment Pointer is at:" + this.ep);
  }

}