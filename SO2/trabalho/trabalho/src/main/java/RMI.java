
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Prates
 */
public interface RMI extends Remote{
    public void ConnectMyDatabase(String PG_HOST,String PG_DB,String USER,String PWD)throws Exception;
    public List list_store_products(String store_id)throws Exception;
    public String helloTo(String name) throws RemoteException;
}
