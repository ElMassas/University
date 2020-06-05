package machine.operations;

import machine.*;

public class PushArguments extends ArgumentsOperations {

    public PushArguments(String d, String n) {
        super(d, n);
    }

    @Override
    public void execute(TISC TISC) {

        BlockActivationLog temp = TISC.getActivationlogByDepth(this.d);

        if (!(temp instanceof FunctionActivationLog))
            System.out.println("Internal ERROR");

        TISC.push(((FunctionActivationLog) temp).getArgument(this.n));

    }
}
