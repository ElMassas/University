package machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
  private Properties properties;

  // Constructor
  public TISC() {
    operationsList = new ArrayList<Operations>();
    labelsPc = new Hashtable<String, Integer>();
    evaluationStack = new Stack<Integer>();
    executionStack = new BlockActivationLog();

    this.auxArgs = new LinkedList<>();
    this.entryOrder = new LinkedList<>();
    this.properties = TISC.get_props();
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

    // Sets enviroment to start on the program enviroment
    this.ep = entryOrder.indexOf("program");

    // Mock program runner //
    try {
      // Call program function
      (new Call("0", "program")).execute(this);

      // Debuging
      if (this.properties.getProperty("debug-preExecutionLogs").compareTo("true") == 0) {
        this.printFDActivationLogs();
        this.printOperationsList();
        this.printLabels();
        System.out.println("RUN:");
      }

      boolean db = this.properties.getProperty("debug-runingLogs").compareTo("true") == 0;

      while (true) {
        if (db)
          System.out.printf("[RUN]:%s\n", this.operationsList.get(this.pc).getClass().getName());

        Operations op = this.operationsList.get(this.pc);
        op.execute(this);

        if (db)
          this.printFDActivationLogs();

        if (!(op instanceof Call))
          this.pc++;

        if (this.executionStack.getControlLink() == null)
          break;
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

  // Properties
  public static final String prop_file = "Properties.properties";

  public static Properties defaults(File file) {
    try {
      file.createNewFile();
      OutputStream out = new FileOutputStream(file);

      Properties prop = new Properties();

      // Default properties
      prop.setProperty("debug-preExecutionLogs", "false");
      prop.setProperty("debug-runingLogs", "false");

      prop.store(out, null);
      return prop;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static Properties get_props() {
    try {
      File temp = new File(prop_file);
      Properties prop;

      if (!temp.exists()) {
        prop = defaults(temp);
      } else {

        InputStream is = new FileInputStream(temp);
        prop = new Properties();
        prop.load(is);
      }

      return prop;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  // Testing methods ->To remove<-
  public void printFDActivationLogs() {
    ActivationLog temp = this.executionStack;
    System.out.println("->Execution Stack<-");
    int c = 0;
    while (temp != null) {
      if (c == this.ep)
        System.out.print("[->]:");
      else
        System.out.printf("[%2d]:", c);
      c++;

      System.out.print(temp.getClass().getName() + ":");

      if (temp instanceof BlockActivationLog) {
        BlockActivationLog temp2 = (BlockActivationLog) temp;
        if (temp2.localVariables != null)
          System.out.print(" Variable size " + temp2.localVariables.length);
      }
      if (temp instanceof FunctionActivationLog) {
        FunctionActivationLog temp2 = (FunctionActivationLog) temp;
        System.out.print(" Argument size " + temp2.getArgumentsSize());
      }

      System.out.println();
      temp = temp.getControlLink();
    }
  }

}