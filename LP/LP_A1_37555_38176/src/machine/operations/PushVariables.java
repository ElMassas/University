package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class PushVariables extends VariableOperations {

    public PushVariables(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        int depth = tisc.getEp() + this.d;

        ActivationLog eval = ActivationLog.getActivationLogByDepth(tisc.getExecutionStack(), depth);
        if (!(eval instanceof BlockActivationLog))
            throw new ExecutionException(this, tisc.getPc());

        BlockActivationLog scope = (BlockActivationLog) eval;
        tisc.push(scope.getVariable(this.n));
    }
}
