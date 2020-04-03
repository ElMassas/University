package so2;

import java.io.*;
import java.net.*;
import java.util.Vector;


/** classe que representa o atendimento de um pedido do servico
 * 
 * NOTA -- TEM de ADICIONAR os JARs às libraries do projeto: so2-objfile.jar veiculos3-semAtend.jar
 * 
 * @author jsaias
 */
public class AtendePedido {
    Vector<Registo> repositorio;
    Socket data;

    public AtendePedido(Socket data, Vector<Registo> repositorio) {
	this.data= data;
	this.repositorio= repositorio;
    }



    public void atendePedido() {
	try {
	    System.err.println("  <novo pedido>");
	    Object objPedido= null;
	    // le os dados do pedido, como um OBJECTO "objPedido"		
	    ObjectInputStream ois= new ObjectInputStream(data.getInputStream());
	    objPedido= ois.readObject();
	    
	    // apreciar o objecto com o pedido recebido:
	    if (objPedido==null)
		System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");
	    
	    if (objPedido instanceof PedidoDeConsulta) {
		PedidoDeConsulta pc= (PedidoDeConsulta) objPedido;
		
		// procurar o registo associado a matricula pretendida
		Registo registo= null;  		    
		// pesquisar no servidor (Vector, mais tarde num ficheiro)
		for (int i=0; i<repositorio.size(); i++) {
		    if (repositorio.get(i).getMatricula().equals( pc.getMatricula() ) ) {
			registo= repositorio.get(i);
			break;
		    }
		}		    
		
		// enviar objecto Cliente via socket		    
		ObjectOutputStream oos= new ObjectOutputStream( data.getOutputStream());
		
		if (registo!=null) { // encontrou
		    oos.writeObject(registo);
		}
		else {
		    // aqui, podiamos usar outro objecto
		    // de uma classe de represente a situacao
		    oos.writeObject("NAO ENCONTROU");  
		}
		
		
	    }
	    else if (objPedido instanceof PedidoDeRegisto) {
		PedidoDeRegisto pr= (PedidoDeRegisto) objPedido;
		Registo registo= pr.getRegisto();
		String resposta= "ok";
		boolean repetido= false;
		
		// ver se ja existia registo desta matricula
		for (int i=0; i<repositorio.size(); i++) {
		    if (repositorio.get(i).getMatricula().equals( pr.getRegisto().getMatricula() ) ) {
			System.err.println("pedido de registo para matricula ja existente");
			repetido= true;
			break;
		    }
		}
		
		// adicionar ao rep local
		if (repetido) {
		    resposta= "pedido de registo para matricula ja existente";
		}
		else {
		    repositorio.add( registo );
		}
		
		// responder ao cliente
		ObjectOutputStream oos= new ObjectOutputStream( data.getOutputStream());
		oos.writeObject( resposta );
		
	    }
	    else
		System.out.println("PROBLEMA");
	    
	}
	catch (Exception exNoAtendimento) {
	    exNoAtendimento.printStackTrace();
	}
	finally {  // fechar o socket de dados
	    // fechar o socket de dados dedicado a este cliente:
	    try {
		data.close();
	    }
	    catch (Exception e002) {
	    }
	}
        
    }
	

}