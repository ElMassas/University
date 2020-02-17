public class Médico {
	String nomeMedico;
    int nifMedico;

    Médico(String nomeMedico, int nifMedico){
        setNomeMedico(nomeMedico);
        setNifMedico(nifMedico);
    }

    public void setNifMedico(int nifMedico) {
        this.nifMedico = nifMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    public String getNome() { 
    	return nomeMedico;
    }
}
