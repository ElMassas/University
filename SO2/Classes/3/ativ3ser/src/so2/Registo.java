package so2;

/**
 * Esta classe representa informacao Nota: Serializavel
 */
public class Registo implements java.io.Serializable {

    private String matricula;
    private String nomeProprietario;
    private int anoDeMatricula;

    /**
     * Cria uma instância de Registo, inicializando os atributos com os valores
     * recebidos.
     * 
     * @param matricula        A matricula do veiculo a registar.
     * @param nomeProprietario Nome do proprietario do veiculo.
     * @param anoDeMatricula   Ano de compra do veiculo.
     */
    public Registo(String matricula, String nomeProprietario, int anoMatricula) {
        this.matricula = matricula;
        this.nomeProprietario = nomeProprietario;
        this.anoDeMatricula = anoMatricula;
    }

    // metodos selectores: para consultar valores de atributos
    /**
     * Devolve a matricula do veiculo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devolve o nome do proprietario do veiculo.
     */
    public String getNomeDoProprietario() {
        return nomeProprietario;
    }

    /**
     * Devolve o ano em que o veiculo foi matriculado ou comprado.
     */
    public int getAnoDeMatricula() {
        return anoDeMatricula;
    }

    // da uma versao textual desde objecto
    /**
     * Devolve uma representacao textual desta instância de Registo de Veiculo
     */
    public String toString() {
        return "registo: " + matricula + ", " + nomeProprietario + ", " + anoDeMatricula;
    }

}
