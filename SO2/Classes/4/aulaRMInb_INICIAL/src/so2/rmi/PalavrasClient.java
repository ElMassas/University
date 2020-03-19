package so2.rmi;


import java.util.Vector;

public class PalavrasClient {

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder
	String frase= "";

	if (args.length !=3) { // requer 3 argumentos
	    System.out.println
		("Usage: java so2.rmi.PalavrasClient registryHost registryPort frase");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];
	frase= args[2];


	try {
	    // objeto que fica associado ao proxy para objeto remoto
	    Palavras obj =
		(Palavras) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
						  regPort + "/palavras");
	    

	    // invocacao de metodos remotos

	    String first = obj.primeiraPalavra(frase) ;
	    System.out.println("1a: "+first);

	    Vector<String> v= obj.divide(frase);
	    System.out.println("divisao:");

	    for (int i=0; i<v.size();i++) {
		System.out.println(i+" "+ v.get(i) );
	    }

	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
