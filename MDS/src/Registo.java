import java.util.*;
public class Registo {
	int nifA;
	String admin; 
    String nomeAtleta;
    
    ArrayList <Integer []> registos;

    public Registo(int nifA, String nomeAtleta,String admin) {
        this.nifA = nifA;
        this.nomeAtleta = nomeAtleta;
        this.admin = admin; 
        registos = new ArrayList<>();
    }
    
    public ArrayList <Integer[]> getArray(){
    	return registos;
    }
    
    public int getNif() {
        return nifA;
    }

    public String getNome() {
        return nomeAtleta;
    }
    
    public String getNomeAdmin() {
    	return admin;
    }
    
    public ArrayList<Integer[]> registarDados(Desportista atleta, Exame exame) {
    	Integer [] caixa = new Integer [2];
    	caixa[0] = atleta.getNif();
    	caixa[1] = exame.getNumeroExame();
  
    	registos.add(caixa);
    	System.out.print("ola");
    	return registos;
    }
    
}
