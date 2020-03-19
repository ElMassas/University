package par3cc;

public class Conta {

    private double saldo;

    // construtores
    public Conta() {
        saldo = 0;
    }

    public Conta(double saldoInicial) {
        saldo = saldoInicial;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public  void credito(double valor) {
        synchronized(this){
            System.out.println(" ++credito pedido " + Thread.currentThread().getName() + ", saldo incial=" + saldo);
            
            double saldoTmp = valor + saldo;
            // simular uma demora
            try { Thread.sleep(1000); } catch (Exception e){}

            saldo = saldoTmp;

            notify();


            System.out.println("\t ++credito realizado " + Thread.currentThread().getName() + " saldo= " + saldo);
        }
    }

    public void debito(double valor) throws Exception {
        synchronized(this){
            System.out.println(" ++ debito pedido " + Thread.currentThread().getName() + ", saldo incial=" + saldo);
            
            if(valor > getSaldo()){
                wait();
            }
            
            boolean espera = false;

            double saldoTmp = saldo - valor;
            // simular uma demora
            try { Thread.sleep(1000); } catch (Exception e){}

            saldo = saldoTmp;
            notify();

            System.out.println("\t ++ debito realizado " + Thread.currentThread().getName() + " saldo= " + saldo);
        }
    }

}
