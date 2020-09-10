package machine.activationlogs;

public class ActivationLog {

    private ActivationLog controlLink;
    private ActivationLog accessLink;

    public ActivationLog(ActivationLog controlLink, ActivationLog accessLink) {
        this.controlLink = controlLink;//registos de ativação estão ligados entre si usando cl
        this.accessLink = accessLink;//
    }

    // Get
    public ActivationLog getControlLink() {
        return this.controlLink;
    }

    public ActivationLog getAccessesLink() {
        return this.accessLink;
    }

    // Class Methods
    public static ActivationLog getActivationLogByDepth(ActivationLog top, int depth) {//looks depth for current actiovation log in the execution stack
        for (; depth > 0 && top != null; depth--)
            top = top.getControlLink();
        return top;
    }

}