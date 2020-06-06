package machine.operations;

import machine.*;

public class Jump extends JumpOperation {

    public Jump(String e) {
        super(e);
    }

    @Override
    public void execute(TISC tisc) {
        tisc.setPc(tisc.getAdrByLable(this.e) - 1);
    }
}
