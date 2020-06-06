package machine.activationlogs;

import java.util.List;
import java.util.LinkedList;

public class BlockActivationLog extends ActivationLog {

    // Data Variables
    public List<Integer> localVariables;

    // Constructors
    public BlockActivationLog(ActivationLog cl, ActivationLog al) {
        super(cl, al);
        this.localVariables = new LinkedList<>();
    }

    public BlockActivationLog(ActivationLog cl, ActivationLog al, List<Integer> locals) {
        super(cl, al);
        this.localVariables = locals;
    }

    // Geters and Seters
    public int getVariable(int name) {
        return this.localVariables.get(name);
    }

    public boolean setVariable(int name, int val) {
        this.localVariables.add(name, val);
        return true;
    }

}