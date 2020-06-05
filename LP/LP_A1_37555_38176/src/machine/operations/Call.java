package machine.operations;

import java.util.LinkedList;

import machine.*;

public class Call extends Operations {

    private int d;
    private String e;

    public Call(String d, String e) {
        this.d = Integer.parseInt(d);
        this.e = e;
    }

    @Override
    public void execute(TISC TISC) {
        TISC.callFunction(name);
    }
}
