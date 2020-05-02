package client;

import java.rmi.RemoteException;
import middleware.Service;
import model.User;


public interface ClientOperations extends java.rmi.Remote{
    
    String getProductListByStore(Service service, String storeName) throws RemoteException;
    String checkStores(Service service) throws RemoteException;
    String registerNecessity(Service service, String userEmail, String productName) throws RemoteException;
    String checkNecessityList(Service service) throws RemoteException;
    boolean signalProduct(Service service, String productName, String storeName) throws RemoteException;
    String checkNecessityListForUser(Service service, String userName) throws RemoteException;
    String registerUser(Service service, User user) throws RemoteException;
    String changeUserName(Service service, User user) throws RemoteException;
    String changeUserEmail(Service service, String userEmail) throws RemoteException;
    
}
