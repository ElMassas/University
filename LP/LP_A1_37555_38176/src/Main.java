// Programa principal para a implementacaos da maquina abstracta TISC.

import machine.TISC;

public class Main {

    public static void main(String args[]) throws Exception {
        parser aParser = new parser();
        TISC program;

        // carrega o programa TISC
        program = (TISC) aParser.parse().value;

        // e executa-o
        if (program != null)
            program.run();

        /*
         * for( Operations op : program.getOperationsList())
         * System.out.println(op.toString());
         */
    }
}
