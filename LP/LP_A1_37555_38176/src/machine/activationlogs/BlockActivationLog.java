package machine.activationlogs;

public class BlockActivationLog extends ActivationLog {

    // Data Variables
    public int[] localVariables;

    // Constructors
    public BlockActivationLog(ActivationLog cl, ActivationLog al) {
        super(cl, al);
        this.localVariables = null;
    }

    public BlockActivationLog() {
        this(null, null);
    }

    public void setLocals(int s) {
        this.localVariables = new int[s];
    }

    // Geters and Seters
    public int getVariable(int name) {
        if (name > localVariables.length) {
            BlockActivationLog al = BlockActivationLog.convetToBlockActivationLog(this.getAccessesLink());
            return al.getVariable(name);
        }
        return this.localVariables[name - 1];
    }

    public boolean setVariable(int name, int val) {
        if (name > localVariables.length) {
            BlockActivationLog al = BlockActivationLog.convetToBlockActivationLog(this.getAccessesLink());
            if (al == null)
                return false;
            return al.setVariable(name, val);
        }

        this.localVariables[name - 1] = val;
        return true;
    }

    public static BlockActivationLog convetToBlockActivationLog(ActivationLog log) {
        if (log instanceof BlockActivationLog)
            return (BlockActivationLog) log;
        return null;
    }

}