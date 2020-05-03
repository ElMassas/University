// Programa principal para a implementacaos da maquina abstracta TISC.

public class Main {

    public static void main(String args[]) throws Exception
    {
        parser aParser = new parser();
        TISC tisc;

        // carrega o programa TISC
        tisc = (TISC) aParser.parse().value;

        // e executa-o
        if (tisc != null)
            tisc.execute();

        for( Operations op : tisc.getOperationsList())
            System.out.println(op.toString());
    }
}
