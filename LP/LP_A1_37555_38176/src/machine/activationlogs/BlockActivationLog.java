package machine.activationlogs;

public class BlockActivationLog extends ActivationLog {

    // Data Variables
    public int[] localVariables;

    // Constructors
    public BlockActivationLog(ActivationLog cl, ActivationLog al, int size) {
        super(cl, al);
        this.localVariables = new int[size];
    }

    public BlockActivationLog() {
        this(null, null, 0);
    }

    // Geters and Seters
    public int getVariable(int name) {
        return this.localVariables[name - 1];
    }

    public boolean setVariable(int name, int val) {
        this.localVariables[name - 1] = val;
        return true;
    }

}