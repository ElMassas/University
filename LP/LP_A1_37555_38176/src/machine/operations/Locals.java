package machine.operations;

import machine.*;

public class Locals extends Operations {

    private int a;
    private String v;

    public Locals(String a, String v) {
        this.a = Integer.parseInt(a);
        this.v = v;
    }

    @Override
    public void execute(TISC TISC) {

    }
}
