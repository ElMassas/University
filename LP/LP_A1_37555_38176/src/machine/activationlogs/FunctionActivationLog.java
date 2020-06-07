package machine.activationlogs;

import java.util.List;

public class FunctionActivationLog extends BlockActivationLog {

    private int[] arguments;
    private int returnAdd;
    private int returnEP;

    // Constructors
    public FunctionActivationLog(ActivationLog cl, ActivationLog al, int varSize, int[] arguments, int returnAdd) {
        super(cl, al, varSize);
        this.arguments = arguments;
        this.returnAdd = returnAdd;
    }

    // Geters and Seters
    public int getArgument(int name) {
        return this.arguments[name - 1];
    }

    public boolean setArguments(int name, int val) {

        FunctionDeclarationActivationLog eval = (FunctionDeclarationActivationLog) this.getAccessesLink();

        if (name < 0 || name > eval.getMaxArgs())
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
        FunctionDeclarationActivationLog eval = (FunctionDeclarationActivationLog) this.getAccessesLink();

        if (name < 0 || name < eval.getMaxLocals())
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