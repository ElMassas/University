package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class PushVariables extends VariableOperations {

    public PushVariables(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC TISC) {
        TISC.push(((FunctionActivationLog) TISC.getActivationlogByDepth(this.d)).getVariable(this.n));
    }
}
