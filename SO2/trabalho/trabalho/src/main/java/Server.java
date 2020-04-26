
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Prates
 */
public final class Server{
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
    //Base de dados
    String PG_HOST="localhost";
    String PG_DB="trabalho";
    String USER="postgres";
    String PWD="Heterosexual86";
    // constructor with port 
    public Server(int port) throws RemoteException, AlreadyBoundException 
    { 
        //conecta á base de dados
        
        // starts server and waits for a connection 
        try
        { 
            
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
            RMI rmi=new RMIImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            Registry registry = java.rmi.registry.LocateRegistry.getRegistry(1099);
            registry.bind("rmi",(Remote)rmi);
            System.out.println("RMI started");
            try {
                rmi.ConnectMyDatabase(PG_HOST,PG_DB,USER,PWD);
                System.out.println("DATABASE connected");
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error trying to connect to database");
            }
            
            
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = in.readUTF(); 
                    
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    }
    public static void main(String args[]) throws RemoteException, AlreadyBoundException 
    { 
        Server server = new Server(5000); 
    } 
}
