import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("hello, am I connected?");
        pr.flush();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(isr);

        String str = bf.readLine();
        System.out.println("server: " + str);
        
    }
}