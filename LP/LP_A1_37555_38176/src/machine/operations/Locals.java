package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class Locals extends Operations {

    private int a;
    private int v;

    public Locals(String a, String v) {
        this.a = Integer.parseInt(a);
        this.v = Integer.parseInt(v);
    }

    public int getA() {
        return a;
    }

    public int getV() {
        return v;
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        FunctionActivationLog curr = FunctionActivationLog.convertToFunctionActivationLog(tisc.getExecutionStack());
        curr.setLocals(this.v);

        if (curr.getArgumentsSize() != this.a)
            throw new ExecutionException(this, tisc.getPc(), "Invalid Argument Size");
    }
}
