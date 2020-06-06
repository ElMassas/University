package machine.activationlogs;

public class FunctionDeclarationActivationLog extends ActivationLog {

    private String functionName;
    private int functionPointer;

    public FunctionDeclarationActivationLog(ActivationLog cl, ActivationLog al, String name, int pos) {
        super(cl, al);
        this.functionName = name;
        this.functionPointer = pos;
    }

    // Get
    public String getName() {
        return this.functionName;
    }

    public int getPointer() {
        return this.functionPointer;
    }
}