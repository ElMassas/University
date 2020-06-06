package machine.operations;

import machine.TISC;

public class Jeq extends JumpOperation {

    public Jeq(String e) {
        super(e);
    }

    @Override
    public void execute(TISC tisc) {
        int a = tisc.pop();
        int b = tisc.pop();

        if (a == b)
            tisc.setPc(tisc.getAdrByLable(this.e) - 1);
    }
}
