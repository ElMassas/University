package machine.activationlogs;

import java.util.List;

import machine.operations.ExecutionException;

public class FunctionActivationLog extends BlockActivationLog {

    private List<Integer> arguments;

    // Constructors
    public FunctionActivationLog(ActivationLog cl, ActivationLog al, List<Integer> locals, List<Integer> arguments) {
        super(cl, al, locals);
        this.arguments = arguments;
    }

    // Geters and Seters
    public int getArgument(int name) {
        return this.arguments.get(name);
    }

    public boolean setArguments(int name, int val) {

        FunctionDeclarationActivationLog eval = (FunctionDeclarationActivationLog) this.getAccessesLink();

        if (name < 0 || name > eval.getMaxArgs())
            return false;
        this.arguments.add(name, val);
        return true;
    }

    public int getArgumentsSize() {
        return this.arguments.size();
    }

    @Override
    public boolean setVariable(int name, int val) {
        FunctionDeclarationActivationLog eval = (FunctionDeclarationActivationLog) this.getAccessesLink();

        if (name < 0 || name < eval.getMaxLocals())
            return false;

        return super.setVariable(name, val);
    }

}