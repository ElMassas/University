public class Add extends ArithmeticOperations{

    private final int PC_JP = 4; //4 bytes

    @Override
    public void execute(TISC TISC) {
        super.loadValues(TISC);
        super.setValues(TISC,this.t1 + this.t2 );
        TISC.changePC(PC_JP);
    }
}
