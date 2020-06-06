package machine.activationlogs;

public class FunctionDeclarationActivationLog extends ActivationLog {

    private String functionName;
    private int functionPointer;

    // Aux
    private int maxArgs;
    private int maxLocals;

    public FunctionDeclarationActivationLog(ActivationLog cl, ActivationLog al, String name, int pos, int maxArgs,
            int maxLocals) {
        super(cl, al);
        this.functionName = name;
        this.functionPointer = pos;

        this.maxArgs = maxArgs;
        this.maxLocals = maxLocals;
    }

    // Get
    public String getName() {
        return this.functionName;
    }

    public int getPointer() {
        return this.functionPointer;
    }

    public int getMaxArgs() {
        return this.maxArgs;
    }

    public int getMaxLocals() {
        return this.maxLocals;
    }
}