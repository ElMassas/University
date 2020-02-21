import java.net.*;
import java.io.*;

public class server{
    public static void main(String[] args) throws IOException {
        ServerSocket server_socket = new ServerSocket( 4999);
        Socket socket = server_socket.accept();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(isr);

        String str = bf.readLine();
        System.out.println("client: " + str);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("Hello! Yes you are");
        pr.flush();    
    }
}