
// Programa principal para a implementacaoo da maquina abstracta TISC.
import insstructions.TISC;

public class Main {

  ArrayList<Instructions> instructionList;

  public static void main(String args[])
    throws Exception
  {
    parser aParser = new parser();
    TISC maquina;

    // carrega o programa TISC
    maquina = (TISC) aParser.parse().value;

    // e executa-o
    if (maquina != null)
      maquina.executa();
  }
}
