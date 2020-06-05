package machine.operations;

public abstract class ArgumentsOperations extends Operations {

    public int d, n;

    public ArgumentsOperations(String d, String n) {
        this.d = Integer.parseInt(d);
        this.n = Integer.parseInt(n);
    }

}
