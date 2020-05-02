package server;

import database.DataBase;
import java.rmi.RemoteException;
import java.util.Scanner;
import middleware.Service;
import middleware.ServiceImpl;
import model.Store;

public class Server {
    private static int regPort;
    
    
    public static void main(String args[]) throws Exception {
        String DB_HOST;
        String DB_NAME;
        String DB_USER;
        String DB_PW;

	if (args.length != 5) { 
	    System.out.println("Missing args");
	    System.exit(1);
	}
	
	try {
                      
	    regPort= Integer.parseInt(args[0]);
            
            DB_HOST= args[1];
            DB_NAME= args[2];
            DB_USER= args[3];
            DB_PW= args[4];

            java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);
            
            Service db = new ServiceImpl(DB_HOST, DB_NAME, DB_USER, DB_PW);
            
	    registry.rebind("service", db);

            System.out.println("Server Ready");
            
            System.out.println("Type exit to close server");
            
            Scanner sc = new Scanner(System.in);
            
            while(!sc.nextLine().toUpperCase().equals("EXIT"))
                sc.next();
            
            System.exit(0);
	} 
	catch(RemoteException e) {
            System.out.println("RMI Remote Exception!");
            System.out.println(e.getMessage());
        }
    }
}
