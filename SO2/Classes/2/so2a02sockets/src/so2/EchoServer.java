package so2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int serverPort;

    public EchoServer(int p) {
        serverPort = p;
    }

    public static void main(String[] args) throws IOException {
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

        EchoServer serv = new EchoServer(p);
        serv.servico();   // activa o servico
    }

    // activa o servidor no porto indicado em "serverPort"
    public void servico() throws IOException {
        ServerSocket server_socket = new ServerSocket(serverPort);
        Socket socket = server_socket.accept();

        String ct = "connection established";
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(ct.getBytes());

        while (true) {
            try {

                //Read message
                InputStream socketIn = socket.getInputStream();
                byte[] b = new byte[256];
                int lidos = socketIn.read(b);
                String recv = new String(b, 0, lidos);
                System.out.println("Recebida -> " + recv);

                //send messagge
                socketOut = socket.getOutputStream();
                socketOut.write(recv.getBytes());

            } catch (Exception e) {

            }
        }


        /*
        //receive message
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(isr);

        String str = bf.readLine();
        
        System.out.println("received_client -> " + str);
        
        str += " Hi!";
        
        //send message
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("Hello! Yes you are");
        pr.flush();    

         */
    }

}
