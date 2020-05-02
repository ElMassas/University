package middleware;

import database.DataBase;
import dto.ProductsByStore;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import model.Necessity;
import model.Store;
import model.User;

public class ServiceImpl extends UnicastRemoteObject implements Service, Serializable {
    private DataBase db;
    
    public ServiceImpl(String host, String dbase, String user, String pass) throws RemoteException{
        db = new DataBase(host, dbase, user, pass);
    }

    @Override
    public boolean registerNecessity(Necessity necessity) throws RemoteException{
        return db.registerNecessity(necessity);
    }
    
    @Override
    public ArrayList<String> getNecessityList( ) throws RemoteException {
        return db.getNecessityList();
    }
    
    @Override
    public ArrayList<String> checkStores() throws RemoteException{
        return db.checkStores();
    }
    
    @Override
    public ProductsByStore getProductListByStore(Store store) throws RemoteException{       
        return db.getProductListByStore(store);
    }

    @Override
    public boolean signalProduct(String productName, String storeName) {
        return db.signalProduct(productName, storeName);
    }
    
    @Override
    public ArrayList<Necessity> checkNecessityListForUser(String userEmail) throws RemoteException {
        return db.checkNecessityListForUser(userEmail);
    }

    @Override
    public String registerUser(User user) throws RemoteException {
        return db.registerUser(user);
    }

    @Override
    public String changeUserName(User user) throws RemoteException {
        return db.changeUserName(user);
    }
    
    @Override
    public String changeUserEmail(String userEmail) throws RemoteException {
        return db.changeUserEmail(userEmail);
    }

    
    

}