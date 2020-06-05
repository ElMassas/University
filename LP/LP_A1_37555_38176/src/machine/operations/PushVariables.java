package machine.operations;

import machine.*;

public class PushVariables extends VariableOperations {

    public PushVariables(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC TISC) {
        TISC.push(TISC.getActivationlogByDepth(this.d).getVariable(this.n));
    }
}
