package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class PushArguments extends ArgumentsOperations {

    public PushArguments(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC tisc) {

        ActivationLog temp = ActivationLog.getActivationLogByDepth(tisc.getExecutionStack(), this.d);

        if (!(temp instanceof FunctionActivationLog))
            System.out.println("Internal ERROR");

        tisc.push(((FunctionActivationLog) temp).getArgument(this.n));

    }
}
