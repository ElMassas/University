package so2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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

        if (args.length < 3) {
            System.err.println("Argumentos insuficientes:  java EchoClient ADDRESS PORT MESSAGE");
            System.exit(1);
        }

        try {
            String addr = args[0];
            int p = Integer.parseInt(args[1]);


            EchoClient cl = new EchoClient(addr, p);

            // ler o texto a enviar ao servidor
            String s = args[2];

            cl.go(s);
            
        } catch (Exception e) {
            System.out.println("Problema no formato dos argumentos");
            e.printStackTrace();
        }
    }

    public void go(String msg) throws IOException {
        Socket socket = new Socket(address, sPort);
        
        System.out.println("Enviada -> " + msg);

        //send messagge
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(msg.getBytes());
        
        //Read message
        InputStream socketIn = socket.getInputStream();
        byte[] b = new byte[256];
        int lidos = socketIn.read(b);
        String resp = new String(b, 0, lidos);
        System.out.println("Recebida -> " + resp);
    }

}
