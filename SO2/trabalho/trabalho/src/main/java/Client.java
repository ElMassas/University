
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client{
    
    private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
    
    public Client(String address, int port) throws NotBoundException, Exception 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        //Lookup
        // string to read message from input 
        String line = ""; 
        
        RMI rmi = null;
        try {
            rmi = (RMI) Naming.lookup("rmi");
        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        // keep reading until "Over" is input 
        while (true) 
        { 
            try
            {  
                
                System.out.println("opções: ");
                System.out.println("0-Exit");
                System.out.println("1-list_store_products(String store_id)");
                System.out.println("2-helloTo()");
                
                line = input.readLine();
                
                if(line.equals("0")){
                    break;
                }
                else if(line.equals("1")){
                    System.out.println("store_id: ");
                    line = input.readLine();
                    List<String> list = rmi.list_store_products(line);
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                }
                else if(line.equals("2")){
                    System.out.println(rmi.helloTo(line));
                }
                else{continue;}
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    }
    public static void main(String args[]) throws NotBoundException, Exception 
    {
        Client client = new Client("127.0.0.1", 5000);
    } 
    
}
