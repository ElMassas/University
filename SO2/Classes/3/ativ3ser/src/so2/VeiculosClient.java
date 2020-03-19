package so2;

import java.net.*;
import java.io.*;

public class VeiculosClient {
	private String address = "localhost";
	private int sPort = 0;

	public VeiculosClient(String add, int p) {
		address = add;
		sPort = p;
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Argumentos insuficientes:  java VeiculosClient ADDRESS PORT");
			System.exit(1);
		}

		try {
			String addr = args[0];
			int p = Integer.parseInt(args[1]);

			VeiculosClient cl = new VeiculosClient(addr, p);

			cl.menu(); // interage com o utilizador
		} catch (Exception e) {
			System.out.println("Problema no formato dos argumentos");
			e.printStackTrace();

		}
	}

	public void menu() {
		int lidos;
		byte[] b = new byte[256];
		try {
			while (true) { // ciclo: pede ao utilizador...
				System.out.print("\n\n --- MENU --- \n" + "registar - enviar novo registo para o servidor\n"
						+ "consultar - obter dados sobre o proprietario de um veiculo\n\n> ");

				// ler a opcao
				lidos = System.in.read(b);
				String op = new String(b, 0, lidos - 1);

				if (op.equals("registar")) {
					// ler dados
					String s = null;

					System.out.println("matricula: ");
					lidos = System.in.read(b);
					String matricula = new String(b, 0, lidos - 1);

					System.out.println("nome do proprietario: ");
					lidos = System.in.read(b);
					String nome = new String(b, 0, lidos - 1);

					System.out.println("ano de matricula: ");
					lidos = System.in.read(b);
					s = new String(b, 0, lidos - 1);
					int ano = Integer.parseInt(s);

					PedidoDeRegisto pr = new PedidoDeRegisto(new Registo(matricula, nome, ano));
					enviaPedido(pr);
				} else if (op.equals("consultar")) {
					System.out.println("matricula: ");

					lidos = System.in.read(b);
					String matricula = new String(b, 0, lidos - 1);

					PedidoDeConsulta pc = new PedidoDeConsulta(matricula);
					enviaPedido(pc);
				} else
					System.out.println("opcao invalida");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviaPedido(Pedido p) {
		try {
			Socket s = new Socket(address, sPort);

			// ja esta connected
			// que Streams usar????

			OutputStream socketOut = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(socketOut);
			// escrever a mensagem?

			oos.writeObject(p);

			// ler a resposta e mostrar o resultado

			InputStream socketIn = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(socketIn);

			Object resposta = ois.readObject();
			// fechar o socket
			s.close();

			// ver a resposta - modo simples
			System.out.println("RESPOSTA: " + resposta);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
