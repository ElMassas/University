package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class Locals extends Operations {

    private int a;
    private int v;

    public Locals(String a, String v) {
        this.a = Integer.parseInt(a);
        this.v = Integer.parseInt(v);
    }

    public int getA() {
        return a;
    }

    public int getV() {
        return v;
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        // Praticaly imposible but we still checked
        ActivationLog eval = tisc.getExecutionStack();
        if (!(eval instanceof FunctionActivationLog))
            throw new ExecutionException(this, tisc.getPc(), "Activation Log missmatch");

        // Gets function scope
        FunctionActivationLog scope = (FunctionActivationLog) eval;

        // Eval argument size
        if (scope.getArgumentsSize() != this.a)
            throw new ExecutionException(this, tisc.getPc(), "Invalid Argument Size");
    }
}
