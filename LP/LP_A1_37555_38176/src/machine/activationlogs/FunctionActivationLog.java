package machine.activationlogs;

public class FunctionActivationLog extends BlockActivationLog {

    private int[] arguments;
    private int returnAdd;
    private int returnEP;

    // Constructors
    public FunctionActivationLog(ActivationLog cl, ActivationLog al, int[] arguments, int returnAdd) {
        super(cl, al);
        this.arguments = arguments;
        this.returnAdd = returnAdd;
    }

    // Geters and Seters
    public int getArgument(int name) {
        return this.arguments[name - 1];
    }

    public boolean setArguments(int name, int val) {
        if (name < 0 || name > this.arguments.length)
            return false;
        this.arguments[name - 1] = val;
        return true;
    }

    public int getArgumentsSize() {
        return this.arguments.length;
    }

    public int getReturnEP() {
        return returnEP;
    }

    public int getReturnAdd() {
        return returnAdd;
    }

    @Override
    public boolean setVariable(int name, int val) {

        if (name < 0 || name < this.arguments.length)
            return false;

        return super.setVariable(name, val);
    }

    // Class Methods
    public static FunctionActivationLog convertToFunctionActivationLog(ActivationLog al) {

        if (!(al instanceof FunctionActivationLog))
            return null;

        return (FunctionActivationLog) al;
    }

}