package machine.operations;

import machine.*;

public class SetArguments extends Operations {

    private int n;

    public SetArguments(String n) {
        this.n = Integer.parseInt(n);
    }

    @Override
    public void execute(TISC tisc) {
        tisc.addArgument(this.n, tisc.pop());
    }
}
