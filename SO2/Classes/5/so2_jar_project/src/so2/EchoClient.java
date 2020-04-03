package so2;

import java.io.*;
import java.net.*;

public class EchoClient {

    private String address= null;
    private int sPort= 0;
    
    public EchoClient(String add, int p) {
	address= add;
	sPort=p;
    }
    
    
    public static void main(String[] args){
	// exigir os argumentos necessarios
	if (args.length < 3) {
	    System.err.println("Argumentos insuficientes:  java EchoClient ADDRESS PORT MENSAGEM");
	    System.exit(1);
	}
	
	try {
	    String addr= args[0];
	    int p= Integer.parseInt(args[1]);	
	    
	    EchoClient cl= new EchoClient(addr,p);
	    
	    cl.go( args[2] );   // faz o pretendido
	}
	catch (Exception e) {
	    System.out.println("Problema no formato dos argumentos");
	    e.printStackTrace();
	}
    }
    
    
    
    public void go(String msg) {
	System.out.println("\t vai enviar: "+msg);
	
	Socket s= null;
	  
	// escrever a mensagem?
	OutputStream socketOut= null;
	InputStream socketIn= null;
	try {
	    try {
		s= new Socket(address, sPort);
	    }
	    catch(UnknownHostException e1) {
		System.err.println("ERRO: ao ligar ao servidor "+e1);
		e1.printStackTrace();
		throw e1;
	    }
	    catch(NoRouteToHostException e2) {
		System.err.println("ERRO: ao ligar ao servidor "+e2);
		e2.printStackTrace();
		throw e2;
	    }	    
	    catch (Exception e0) {
		System.err.println("ERRO: ao ligar ao servidor: "+e0);
		throw e0;
	    }
	    socketOut= s.getOutputStream();
	    socketIn= s.getInputStream();

	    try {
		msg= msg+"\n";  // por causa do bufferedReader em aula03
		socketOut.write( msg.getBytes() );
		socketOut.flush();
	    }
	    catch (IOException ioe1) {
		System.err.println("ERRO: ao enviar o pedido: "+ioe1);
		throw ioe1;
	    }
	    
	    byte[] b= new byte[256];
	    int lidos= 0;
	    try {
		lidos= socketIn.read(b,0,256);
	    }
	    catch (IOException ioe) {
		System.err.println("ERRO: ao ler a resposta: "+ioe);
		throw ioe;
	    }
	    
	    String resp= new String(b,0,lidos);
	    
	    System.out.println("\t resposta do SERVIDOR: "+resp);
	    
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("ERRO: durante a comunicacao com o servidor: "+e);
	}
	finally {
	    // fechar sempre o socket
	    try {
		s.close();
	    }
	    catch (Exception e) {
		System.err.println(e);
	    }
	}
    }
    
}
