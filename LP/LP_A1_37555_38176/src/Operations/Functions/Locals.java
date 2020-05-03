package Operations.Functions;

import Operations.Operations;
import TISC.Machine;

public class Locals extends Operations {

    private int a;
    private String v;

    public Locals( int a, String v){
        this.a = a;
        this.v = v;
    }

    @Override
    public void execute(Machine machine) {

    }
}
