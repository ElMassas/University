public class Exame {
    int numeroExame;
    String atleta;
    boolean exameRealizado = false;
    String medico;

    public Exame(int numeroExame, String atleta, String medico) {
        this.numeroExame = numeroExame;
        this.atleta = atleta;
        this.medico = medico;
       
    }

    public int getNumeroExame() {
        return numeroExame;
    }

    public void setNumeroExame(int numeroExame) {
    	this.numeroExame = numeroExame ; 
    }
   
    public boolean realizarExame(Desportista desportista) {
    		exameRealizado = true;
    		return exameRealizado;
    	
    	
    }
}
