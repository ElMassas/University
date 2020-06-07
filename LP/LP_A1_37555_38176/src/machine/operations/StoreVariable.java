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

        if (!(eval instanceof BlockActivationLog)) {
            throw new ExecutionException(this, tisc.getPc(), "Scope Missmatch");
        }

        ((BlockActivationLog) eval).setVariable(this.n, tisc.pop());
    }
}
