package machine.operations;

import machine.*;

public class StoreVariable extends VariableOperations {

    public StoreVariable(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC TISC) {
        TISC.getActivationlogByDepth(this.d).setVariable(this.n, TISC.pop());
    }
}
