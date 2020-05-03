// Programa principal para a implementacaos da maquina abstracta TISC.
import TISC.Machine;

public class Main {

    public static void main(String args[]) throws Exception
    {
        parser aParser = new parser();
        Machine machine;

        // carrega o programa TISC
        machine = (Machine) aParser.parse().value;

        // e executa-o
        if (machine != null)
            machine.execute();


    }
}
