package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import middleware.Service;
import model.User;

public class Client {

    public String regHost;
    public String regPort;
    public Scanner sc;
    public String userName, userEmail;
    ClientOperationsImpl operations = new ClientOperationsImpl();

    public Client(String regHost, String regPort) {
        this.regHost = regHost;
        this.regPort = regPort;
        this.sc = new Scanner(System.in);
    }


    public void saveInfoToFileFromClient(String userEmail, String option, String messages){
        ClientLastInfo save = new ClientLastInfo(userEmail, option);
        String[] separateMessages = messages.split("|");
        save.setInput(separateMessages);
        
        OutputStream out = null;
        ObjectOutputStream outStream = null;
        
        File myFile = new File(userEmail + "_lastInfo.txt");
        
        
        
        try{
            myFile.createNewFile();
            out = new FileOutputStream(myFile);
            outStream = new ObjectOutputStream(out);
            outStream.writeObject(save);
            outStream.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(outStream != null)
                    outStream.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }

    
    public void readInfoFromFile(){
        
    }
    
    public void run() {
        try {
            Service rmiObject = (Service) java.rmi.Naming.lookup("rmi://" + regHost + ":"
                    + regPort + "/service");

            System.out.println("<--Connected-->");
            
            registerUser(rmiObject);
            
        } catch (Exception e) {
            System.out.println("Server is offline\nTry again later");
            e.printStackTrace();
        }
    }

    public void registerUser(Service service) throws RemoteException, Exception{
        System.out.print("\nPlease insert your name!\n");
        userName = sc.nextLine();
        System.out.print("\nPlease insert your email!\n");
        userEmail = sc.nextLine();
        User currentUser = new User(userName, userEmail);
        
        System.out.println(operations.registerUser(service, currentUser));
        
        menu(service, currentUser);
        
    }
    
    public void menu(Service service, User currentUser) throws Exception {
        
        String storeName, productName;        

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\tWelcome to the NECESSITRON9001 main menu!!");
        System.out.println("\tPlease choose an option.");
        System.out.print("\t 1-> Register a necessity for a product."
                + "\n\t 2-> Check what people have a necessity for."
                + "\n\t 3-> Check Stores using the system."
                + "\n\t 4-> Check Products inside a given store."
                + "\n\t 5-> Signal that you have seen a product which there is a necessity for."
                + "\n\t 6-> Check if a product you are looking for as been found."
                + "\n\t 7-> Check your User info."
                + "\n\t 8-> Change your name."
                + "\n\t 9-> Change your email.\n");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        while (sc.hasNext()) {
            Scanner option = new Scanner(System.in);
            try {
                switch (sc.next()) {
                    case "1":
                        System.out.print("\nPlease insert the product you are looking for!");
                        productName = option.nextLine();
                        saveInfoToFileFromClient(currentUser.getEmail(), "1", productName);
                        
                        System.out.println(operations.registerNecessity(service, currentUser.getEmail(), productName));
                        break;
                    case "2":
                        saveInfoToFileFromClient(currentUser.getEmail(), "2", "");
                        
                        System.out.println(operations.checkNecessityList(service));
                        break;
                    case "3":
                        saveInfoToFileFromClient(currentUser.getEmail(), "3", "");
                        
                        System.out.println(operations.checkStores(service));
                        break;
                    case "4":
                        System.out.print("\nPlease insert the store name which you want to the see the products of: ");
                        storeName = option.nextLine();
                        saveInfoToFileFromClient(currentUser.getEmail(), "4", storeName);
                        
                        System.out.println(operations.getProductListByStore(service, storeName));
                        break;
                    case "5":
                        System.out.print("\nPlease insert the store name in which you found the product: ");
                        storeName = option.nextLine();
                        System.out.print("\nPlease insert the product name that someone has a necsessity for: ");
                        productName = option.nextLine();
                        saveInfoToFileFromClient(currentUser.getEmail(), "5", storeName +"|" + productName);
                                
                        if (operations.signalProduct(service, productName, storeName)) {
                            System.out.println("The User which has a necessity for this product has been notified. Thank you!");
                        } else {
                            System.out.println("ERROR 404 necessity not found!");
                        }
                        break;
                    case "6":
                        System.out.print("\nPlease insert your email!");
                        userEmail = option.nextLine();
                        saveInfoToFileFromClient(userEmail, "6", userEmail);
                        
                        System.out.println(operations.checkNecessityListForUser(service, userEmail));//needs to be change in other classes
                        break;
                    case "7":
                        saveInfoToFileFromClient(currentUser.getEmail(), "7", "");
                        
                        System.out.println("\nYour name -> " + currentUser.getName() + "\nYour email -> " + currentUser.getEmail());
                        break;
                    case "8":
                        System.out.println("\nInsert new name here: ");
                        userName = option.nextLine();
                        currentUser.setName(userName);
                        saveInfoToFileFromClient(currentUser.getEmail(), "8", userName);
                        
                        System.out.println(operations.changeUserName(service, currentUser));
                        break;
                    case "9":
                        System.out.println("\nInsert new email here: ");
                        userEmail = option.nextLine();
                        currentUser.setEmail(userEmail);
                        saveInfoToFileFromClient(currentUser.getEmail(), "9", userEmail);
                        
                        System.out.println(operations.changeUserEmail(service, userEmail));
                        break;
                    default:
                        System.out.println("Please enter a valid option!");

                }
            } catch (Exception e) {
                System.out.println("Server is down.");
            }
        }
    }

    public static void main(String args[]) throws Exception {
        String regHost;
        String regPort;

        if (args.length != 2) { // requires 2 arguments
            System.out.println("Missing argument");
            System.exit(1);
        }

        regHost = args[0];
        regPort = args[1];

        Scanner sc = new Scanner(System.in);

        Client client = new Client(args[0], args[1]);
        client.run();

        while (!sc.nextLine().toUpperCase().equals("CLOSE")) {
            sc.next();
        }

        System.exit(0);

    }
}
