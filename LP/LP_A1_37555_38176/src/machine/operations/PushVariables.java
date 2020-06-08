package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class PushVariables extends VariableOperations {

    public PushVariables(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        int depth = this.d;

        ActivationLog temp = tisc.getExecutionStack();

        for (; depth > 0; depth--)
            temp = temp.getAccessesLink();

        ActivationLog eval = temp;

        if (!(eval instanceof BlockActivationLog))
            throw new ExecutionException(this, tisc.getPc(), "Scope Missmatch");

        BlockActivationLog scope = (BlockActivationLog) eval;
        tisc.push(scope.getVariable(this.n));
    }
}
