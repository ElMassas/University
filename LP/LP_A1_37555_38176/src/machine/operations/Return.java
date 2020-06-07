package machine.operations;

import machine.*;
import machine.activationlogs.*;

public class Return extends Operations {

    public Return() {
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {

        // Eval Process
        FunctionActivationLog current = FunctionActivationLog.convertToFunctionActivationLog(tisc.getExecutionStack());
        if (current == null)
            throw new ExecutionException(this, tisc.getPc(), "Scope Missmatch");

        // Check if its the program end
        ActivationLog eval = current.getAccessesLink();
        if (eval instanceof FunctionDeclarationActivationLog) {
            FunctionDeclarationActivationLog transform = (FunctionDeclarationActivationLog) eval;
            if (transform.getName().compareTo("program") == 0) {
                tisc.end = true;
                return;
            }
        }

        // Set enviroment and program counter
        tisc.setEp(current.getReturnEP());
        tisc.setPc(current.getReturnAdd());

        // Pop scope from stack
        tisc.setExecutionStack(current.getControlLink());
    }
}
