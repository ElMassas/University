package machine.operations;

import machine.*;

public class Print extends Operations {
    @Override
    public void execute(TISC tisc) {
        System.out.print(tisc.pop());
    }
}
