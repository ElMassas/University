package machine.operations;

import machine.*;

public class PrintString extends Operations {

    private String s;

    public PrintString(String s) {
        this.s = s;
    }

    @Override
    public void execute(TISC TISC) {
        System.out.print(this.s);
    }
}
