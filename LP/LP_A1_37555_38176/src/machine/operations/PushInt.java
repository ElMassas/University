package machine.operations;

import machine.*;

public class PushInt extends Operations {

    private int i;

    public PushInt(String i) {
        this.i = Integer.parseInt(i);
    }

    @Override
    public void execute(TISC TISC) {
        TISC.push(this.i);
    }
}
