package machine.operations;

import machine.*;
import machine.activationlogs.FunctionActivationLog;

public class StoreVariable extends VariableOperations {

    public StoreVariable(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC TISC) {
        ((FunctionActivationLog) TISC.getActivationlogByDepth(this.d)).setVariable(this.n, TISC.pop());
    }
}
