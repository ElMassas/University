package par3cc;

public class ThreadsBancarias extends Thread {

    public static final int PROPOSITO_DEBITAR = 0;
    public static final int PROPOSITO_CREDITAR = 1;

    // um objecto (partilhado por todas as threads)
    public static Conta conta = new Conta();

    // o proposito desta thread em particular
    private int proposito;

    public ThreadsBancarias(int proposito) {
        this.proposito = proposito;
    }

    public int getProposito() {
        return proposito;
    }

    public boolean temPropositoDebitar() {
        return proposito == PROPOSITO_DEBITAR;
    }

    public boolean temPropositoCreditar() {
        return proposito == PROPOSITO_CREDITAR;
    }

    public void run() {
        //  em paralelo
        String name = Thread.currentThread().getName();
        try {
            System.out.println("# " + name + " ponto 0 ENTRADA");

		//Thread.sleep(2000);
            // ...
            if (this.temPropositoCreditar()) {
                conta.credito(100);
            } else if (this.temPropositoDebitar()) {
                conta.debito(50);
            }

            System.out.println("\t# " + name + " ponto 1 SAIDA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
	// 3 objectos do tipo Thread (subclasse ThreadsBancarias)
        // uma credita 100, as outras 2 debitam 50

        ThreadsBancarias p1 = new ThreadsBancarias(PROPOSITO_CREDITAR);
        ThreadsBancarias p2 = new ThreadsBancarias(PROPOSITO_DEBITAR);
        ThreadsBancarias p3 = new ThreadsBancarias(PROPOSITO_DEBITAR);

        // lancar as 3, cada uma executara por si
        p1.start();
        p2.start();
        p3.start();
    }

} 
