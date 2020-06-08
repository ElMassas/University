package machine.activationlogs;

public class FunctionActivationLog extends BlockActivationLog {

    private int[] arguments;
    private int returnAdd;
    private int returnEP;

    // Aux
    public String name;

    // Constructors
    public FunctionActivationLog(ActivationLog cl, ActivationLog al, int[] arguments, int returnAdd, String name) {
        super(cl, al);
        this.arguments = arguments;
        this.returnAdd = returnAdd;
        this.name = name;
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

    public static ActivationLog findByName(ActivationLog top, String name) {
        for (; top != null; top = top.getControlLink()) {
            FunctionActivationLog conv = convertToFunctionActivationLog(top);
            if (conv != null && conv.name.compareTo(name) == 0)
                return top;
        }
        return null;
    }

}