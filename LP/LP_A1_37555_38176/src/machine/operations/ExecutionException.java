package machine.operations;

public class ExecutionException extends Exception {

    private static final long serialVersionUID = 1L;
    private Operations op;
    private int line;

    public ExecutionException(Operations op, int line, String mesage) {
        super(mesage);
        this.op = op;
        this.line = line;
    }

    // Printer
    public void printExecutionException() {
        System.out.printf("* Execution Error at:%d->%s\n* motive:%s\n", this.line, this.op.getClass().getName(),
                this.getMessage());
    }

}