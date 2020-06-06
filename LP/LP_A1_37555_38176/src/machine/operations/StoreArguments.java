package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class StoreArguments extends ArgumentsOperations {

    public StoreArguments(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC tisc) {
        int depth = tisc.getEp() + this.d;

        ActivationLog temp = ActivationLog.getActivationLogByDepth(tisc.getExecutionStack(), depth);

        if (!(temp instanceof FunctionActivationLog))
            System.out.println("unmatched Activation log error");

        ((FunctionActivationLog) temp).setArguments(this.n, tisc.pop());
    }
}
