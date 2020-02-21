package so2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//https://docs.oracle.com/javase/tutorial/networking/sockets/index.html
public class EchoClient {

    private String address = null;
    private int sPort = 0;

    public EchoClient(String add, int p) {
        address = add;
        sPort = p;
    }

    public static void main(String[] args) throws IOException {
        // exigir os argumentos necessarios

        if (args.length < 2) {
            System.err.println("Argumentos insuficientes:  java EchoClient ADDRESS PORT");
            System.exit(1);
        }

        try {
            String addr = args[0];
            int p = Integer.parseInt(args[1]);



            EchoClient cl = new EchoClient(addr, p);

            // ler o texto a enviar ao servidor
            byte[] b = new byte[256];
            int lidos = System.in.read(b);
            String s = new String(b, 0, lidos -1);

            cl.go(s);   // faz o pretendido
        } catch (Exception e) {
            System.out.println("Problema no formato dos argumentos");
            e.printStackTrace();
        }
    }

    public void go(String msg) throws IOException {
        Socket socket = new Socket(address, sPort);
        boolean connected = true;
        // exercicio 1: mostrar a mensagem que vai ser enviada
        System.out.println(msg);

        /*while(connected){
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(isr);
            
            
        }*/
        // ...
        // ... exercicio 3
        // ja esta connected
        // escrever a mensagem?
        //OutputStream socketOut = s.getOutputStream();
        //InputStream socketIn = s.getInputStream();

    }

}
