package so2;

import java.io.*;
import java.net.*;


public class EchoServer {
    
    private int serverPort;	
    
    public EchoServer(int p) {
	serverPort= p;		
    }
    
    
    public static void main(String[] args){
	System.err.println("SERVER...");
	if (args.length<1) {
	    System.err.println("Missing parameter: port number");	
	    System.exit(1);
	}
	int p=0;
	try {
	    p= Integer.parseInt( args[0] );
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.exit(2);
	}
	
	
	EchoServer serv= new EchoServer(p);
	serv.servico();   // activa o servico
    }

    
    // activa o servidor no porto indicado em "serverPort"
    public void servico() {
	
	// um servidor TCP: ver outro exemplo no livro
	
        ServerSocket server= null;

        try {
	    // inicializar o socket e associa-lo ao porto local
            server= new ServerSocket(serverPort);
	    
	    // ciclo de atendimento dos pedidos
	    while (true) {
		
		Socket data= null;
                try {
                    data= server.accept();
		    System.err.println("\t chegou um pedido");
		    

		    // agora o atendimento faz-se lendo/escrevendo
		    // para o novo socket de dados: "data"
		    
		    // podemos usar Streams associados ao socket
		    // outra classe muito usada Readers. Ver java.io
		    
		    // exemplo com um de cada
                    DataOutputStream sout= new DataOutputStream(data.getOutputStream());		    
		    BufferedReader breader
			= new BufferedReader(new InputStreamReader(data.getInputStream()));
		    
		    String msgEcho= breader.readLine();
		    System.err.println("\t\t pedido: "+msgEcho);
		    
		    
		    // depois incluir aqui a alteracao do JAR
		    // ...
		    

		    msgEcho= "Ola! "+msgEcho+" Adeus";
		    System.err.println("\t\t a resposta vai ser: "+ msgEcho);

		    sout.writeUTF(msgEcho);
		    
		}
		catch(Exception e) {
		    e.printStackTrace();
		    System.err.println("PROBLEMA no atendimento do pedido: "+e);
		}
		finally {
		    // muito importante: fechar o socket de dados
		    if (data!=null) {
			try {
			    data.close();
			}
			catch (Exception ec) {
			    System.err.println(ec);
			}
		    }
		}
		
		// ... e volta ao ciclo de atendimento
	    }

	}
	catch(Exception e) {
	    e.printStackTrace();
	    System.err.println("PROBLEMA no funcionamento do servidor: "+e);
	}
    }


}
