package machine.activationlogs;

import java.util.List;

public class FunctionActivationLog extends BlockActivationLog {

    private List<Integer> arguments;

    // Constructors
    public FunctionActivationLog(BlockActivationLog current, List<Integer> locals, List<Integer> arguments) {
        super(current, locals);
        this.arguments = arguments;
    }

    // Geters and Seters
    public int getArgument(int name) {
        return this.arguments.get(name);
    }

    public void setArguments(int name, int val) {
        this.arguments.add(name, val);
    }

    public int getArgumentsSize() {
        return this.arguments.size();
    }
}