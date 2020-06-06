package machine.operations;

public class ExecutionException extends Exception {

    private Operations op;
    private int line;

    public ExecutionException(Operations op, int line) {
        super();
        this.op = op;
        this.line = line;
    }

    // Printer
    public void printExecutionException() {
        System.out.printf("* Execution Error at:%d->%s\n* motive:%s\n", this.line, this.op.getClass().getName(),
                this.getMessage());
    }

}