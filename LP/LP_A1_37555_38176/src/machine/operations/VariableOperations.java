package machine.operations;

public abstract class VariableOperations extends Operations {

    public int d, n;

    public VariableOperations(String d, String n) {
        this.d = Integer.parseInt(d);
        this.n = Integer.parseInt(n);
    }

}
