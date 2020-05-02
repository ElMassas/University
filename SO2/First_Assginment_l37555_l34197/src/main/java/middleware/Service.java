package middleware;

import dto.ProductsByStore;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Necessity;
import model.Store;
import model.User;

public interface Service extends java.rmi.Remote {
    boolean registerNecessity(Necessity necessity) throws RemoteException;
    ArrayList<String> getNecessityList() throws RemoteException;
    ArrayList<String> checkStores() throws RemoteException;
    ProductsByStore getProductListByStore(Store store) throws RemoteException;
    boolean signalProduct(String productName, String storeName) throws RemoteException;
    ArrayList<Necessity> checkNecessityListForUser(String userName) throws RemoteException;
    String registerUser(User user) throws RemoteException;
    String changeUserName(User user) throws RemoteException;
    String changeUserEmail(String userEmail) throws RemoteException;
    
    
    //TO_DO
    //function to assync notify clients that a necessity they have has been found
}
