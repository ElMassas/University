public class Main {
	public static void main (String [] args) {
		
		
		Desportista atleta = new Desportista("pois","terceira",92345678,"Portuguesa","Sporting",false,1234,"Miguel");
		Médico doctor = new Médico ("Joaquim",1234);
		Exame exame = new Exame(1, atleta.getNome(),doctor.getNome());
		
		Administrador admin = new Administrador("Professor");
		
		if(exame.realizarExame(atleta)==true) {
			Inscrição inscrito = new Inscrição(exame.getNumeroExame(),atleta.getClube(),atleta.getNif());
			Registo register = new Registo(atleta.getNif(),atleta.getNome(),admin.getNome());
			register.registarDados(atleta, exame);
			
			Recibo recibo = new Recibo(register);
		//	System.out.println("Foi emitido o recibo do atleta" + " " + atleta.getNome() + " com NIF " + atleta.getNif());
			
		
		}
		else {
			System.out.println("O atleta tem de realizar o exame"); 
		}
		
	}
}
