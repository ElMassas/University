package machine.operations;

import machine.TISC;

public class Jlt extends JumpOperation {

    public Jlt(String e) {
        super(e);
    }

    @Override
    public void execute(TISC tisc) {
        int a = tisc.pop();
        int b = tisc.pop();

        if (b < a)
            tisc.setPc(tisc.getAdrByLable(this.e) - 1);
    }
}
