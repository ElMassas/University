package client;

import dto.ProductsByStore;
import java.rmi.RemoteException;
import java.util.ArrayList;
import middleware.Service;
import model.Necessity;
import model.Store;
import model.User;


public class ClientOperationsImpl implements ClientOperations {

    @Override
    public String getProductListByStore(Service service, String storeName) throws RemoteException{
        Store store = new Store();
        store.setName(storeName);
        ProductsByStore returnValue = service.getProductListByStore(store);
        return returnValue.toString();
    }

    @Override
    public String checkStores(Service service) throws RemoteException {
        String output = "\nStores: ";
        ArrayList <String> stores = service.checkStores();
        for(int i = 0; i < stores.size(); i++){
            output += "\n|" + stores.get(i);
        }
        return output;
    }

    @Override
    public String registerNecessity(Service service, String userEmail, String productName) throws RemoteException {
        Necessity necessity = new Necessity();
        necessity.setProductName(productName);
        necessity.setUserEmail(userEmail);
        if(service.registerNecessity(necessity))
            return "Necessity registered sucessufully";
        return "problem registring your necessity, you may have registerd it already";
    }

    @Override
    public String checkNecessityList(Service service) throws RemoteException {
        String output = "\nNecessities:";
        ArrayList<String> necessities = service.getNecessityList();
        for(int i = 0; i < necessities.size(); i++){
            output += "\n|" + necessities.get(i);
        }
        
        return output;
    }

    @Override
    public boolean signalProduct(Service service, String productName, String storeName) throws RemoteException {
        return service.signalProduct(productName, storeName);
    }

    @Override
    public String checkNecessityListForUser(Service service, String userName) throws RemoteException{
        String output ="\nYour necessities that have been signaled:";
        ArrayList<Necessity> userNecessities = service.checkNecessityListForUser(userName);
        for(int i = 0; i < userNecessities.size(); i++){
            output += "\n| product -> " + userNecessities.get(i).getProductName();
            output += "| store -> " + userNecessities.get(i).getStoreName();
        }
        return output;
    }

    @Override
    public String registerUser(Service service, User user) throws RemoteException {
        return service.registerUser(user);
    }

    @Override
    public String changeUserName(Service service, User user) throws RemoteException {
        service.changeUserName(user);
        
        return "Your name has sucessufully been changed to: " + user.getName();
    }

    @Override
    public String changeUserEmail(Service service, String userEmail) throws RemoteException {
        service.changeUserEmail(userEmail);
        
        return "Your email has sucessufully been changed to: " + userEmail;
    }

    

}
