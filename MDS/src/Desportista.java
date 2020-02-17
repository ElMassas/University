
public class Desportista {
	String codigo_postal;
    String morada;
    int telefone;
    String nacionalidade;
    String clube;
    boolean alto_rendimento;
    int nif;
    String nome;

    Desportista(String codigo_postal, String morada, int telefone, String nacionalidade, String clube, boolean alto_rendimento, int nif, String nome){
        setCodigo_postal(codigo_postal);
        setNome(nome);
        setAlto_rendimento(alto_rendimento);
        setClube(clube);
        setMorada(morada);
        setNacionalidade(nacionalidade);
        setNif(nif);
        setTelefone(telefone);
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public boolean isAlto_rendimento() {
        return alto_rendimento;
    }

    public void setAlto_rendimento(boolean alto_rendimento) {
        this.alto_rendimento = alto_rendimento;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
