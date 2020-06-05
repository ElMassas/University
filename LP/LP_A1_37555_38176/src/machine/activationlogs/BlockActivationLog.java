package machine.activationlogs;

import java.util.List;
import java.util.LinkedList;

public class BlockActivationLog {

    // Data Variables
    private BlockActivationLog controlLink;
    private BlockActivationLog acssesLink;
    private List<Integer> localVariables;

    // Constructors
    public BlockActivationLog() {
        this.controlLink = null;
        this.localVariables = new LinkedList<>();
    }

    public BlockActivationLog(BlockActivationLog current, List<Integer> locals) {
        this.controlLink = current;
        this.localVariables = locals;
    }

    // Geters and Seters
    public BlockActivationLog getControlLink() {
        return this.controlLink;
    }

    public int getVariable(int name) {
        return this.localVariables.get(name);
    }

    public void setVariable(int name, int val) {
        this.localVariables.add(name, val);
        ;
    }

}