public class Inscrição {
	int numero_exame;
    String clube;
    int nif;
    boolean inscrito =  false;
    
    public Inscrição(int numero_exame, String clube, int nif) {
        this.numero_exame = numero_exame;
        this.clube = clube;
        this.nif = nif;
    }

    public boolean fezInscricao(int nif) {
    	inscrito = true;
    	return inscrito;
    }
    
}
