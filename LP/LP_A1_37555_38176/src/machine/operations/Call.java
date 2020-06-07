package machine.operations;

import machine.*;
import machine.activationlogs.*;
import java.util.List;

public class Call extends Operations {

    private int d;
    private String e;

    public Call(String d, String e) {
        this.d = Integer.parseInt(d);
        this.e = e;
    }

    @Override
    public void execute(TISC tisc) throws ExecutionException {
        // Calculate depth relative to the enviroment pointer
        int functionDepth = tisc.getEp() + this.d;

        // Get Scope
        ActivationLog functionDeclarationScope = ActivationLog.getActivationLogByDepth(tisc.getExecutionStack(),
                functionDepth);

        // Check if its a Declaration Scope
        if (!(functionDeclarationScope instanceof FunctionDeclarationActivationLog))
            throw new ExecutionException(this, tisc.getPc(), "Invalid Scope");

        // Cast to declaration scope
        FunctionDeclarationActivationLog declarationScope = (FunctionDeclarationActivationLog) functionDeclarationScope;

        // Deap copy the list to an array
        List<Integer> temp2 = tisc.getArguments();
        int[] argumentArray = new int[temp2.size()];
        int c = 0;
        for (int i : temp2) {
            argumentArray[c] = i;
            c++;
        }

        // Create a new Scope for the function
        FunctionActivationLog callScope = new FunctionActivationLog(tisc.getExecutionStack(), declarationScope,
                declarationScope.getMaxLocals(), argumentArray, tisc.getPc());

        // Reset the temporary arguments storage
        tisc.cleanArguments();

        // Sets the top of the stack to the new scope
        tisc.setExecutionStack(callScope);

        // The enviroment pointer becomes the top of the stack
        tisc.setEp(0);

        // Move PC
        tisc.setPc(tisc.getAdrByLable(this.e));
    }
}
