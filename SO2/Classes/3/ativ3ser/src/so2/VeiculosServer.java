package so2;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class VeiculosServer {
	private int serverPort;

	private Vector<Registo> repositorio;

	public VeiculosServer(int p) {
		serverPort = p;
		repositorio = new Vector(); // INICIALIZE o Vector
	}

	public static void main(String[] args) {
		System.err.println("SERVER...");
		if (args.length < 1) {
			System.err.println("Missing parameter: port number");
			System.exit(1);
		}
		int p = 0;
		try {
			p = Integer.parseInt(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(2);
		}

		VeiculosServer serv = new VeiculosServer(p);
		serv.servico(); // activa o servico
	}

	public void servico() {

		try {

			// inicializa o socket para receber ligacoes
			ServerSocket server = new ServerSocket(serverPort);

			System.out.println("SERVIDOR LIGADO");

			while (true) {
				// espera uma ligacao
				// ... accept()
				Socket socketServer = server.accept();
				Object resposta = "";

				try {
					Object objPedido = null;
					// le os dados do pedido, como um OBJECTO "objPedido"
					InputStream socketIn = socketServer.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(socketIn);
					objPedido = ois.readObject();

					OutputStream socketOut = socketServer.getOutputStream();

					ObjectOutputStream oos = new ObjectOutputStream(socketOut);

					// apreciar o objecto com o pedido recebido:
					if (objPedido == null)
						System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");

					if (objPedido instanceof PedidoDeConsulta) {
						PedidoDeConsulta pc = (PedidoDeConsulta) objPedido;

						boolean encontrou = false;

						// procurar o registo associado a matricula pretendida
						for (int i = 0; i < repositorio.size(); i++) {
							if (repositorio.get(i).getMatricula().equals(pc.getMatricula())) {
								resposta = (String) ("-[" + pc.getMatricula() + "]-");
								encontrou = true;
								break;
							}
						}

						// pesquisar no servidor (Vector, mais tarde num ficheiro)

						// enviar objecto Cliente via socket
						// se encontra devolve o registo, se não, devolve um novo objecto ou string a
						// representar que nao encontrou

						if (encontrou) {
							oos.writeObject(resposta);
						} else {
							resposta = "Registo não encontrado";
							oos.writeObject(resposta);
						}

					} else if (objPedido instanceof PedidoDeRegisto) {
						PedidoDeRegisto pr = (PedidoDeRegisto) objPedido; // ...

						boolean encontrou = false;
						// ver se ja existia registo desta matricula
						for (int i = 0; i < repositorio.size(); i++) {
							if (repositorio.get(i).getMatricula().equals(pr.getRegisto().getMatricula())) {
								encontrou = true;
								break;
							}
						}

						// adicionar ao rep local (se nao e' uma repeticao)
						if (encontrou) {
							resposta = "-[Registo existente]-";
						} else {
							repositorio.add(pr.getRegisto());
							resposta = "-[Registo adicionado]-";
						}

						// responder ao cliente

						oos.writeObject(resposta);

					} else
						System.out.println("PROBLEMA");

				} catch (Exception exNoAtendimento) {
					exNoAtendimento.printStackTrace();
				} finally { // fechar o socket de dados
					// fechar o socket de dados dedicado a este cliente:

					try {
						socketServer.close();
					} catch (Exception e002) {
					}
				}

			} // ... ciclo de atendimento

		} catch (Exception problemaBindAccept) {
			problemaBindAccept.printStackTrace();
		}

	}

}
