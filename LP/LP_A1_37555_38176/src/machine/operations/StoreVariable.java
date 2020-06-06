package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class StoreVariable extends VariableOperations {

    public StoreVariable(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        int depth = tisc.getEp() + this.d;
        ActivationLog eval = ActivationLog.getActivationLogByDepth(tisc.getExecutionStack(), depth);

        if (!(eval instanceof FunctionActivationLog)) {
            throw new ExecutionException(this, tisc.getPc(), "Scope Missmatch");
        }

        ((FunctionActivationLog) eval).setVariable(this.n, tisc.pop());
    }
}
