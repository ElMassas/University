
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class RMIImpl extends UnicastRemoteObject implements RMI,java.io.Serializable {
    java.sql.Connection con= null;
    //java.sql.Statement stmt=null;
    public RMIImpl() throws java.rmi.RemoteException{
        super();
        System.out.println("Creating RMI Object");
    }
    public void ConnectMyDatabase(String PG_HOST,String PG_DB,String USER,String PWD)throws Exception{
        try {
            Class.forName ("org.postgresql.Driver");        
            // url = "jdbc:postgresql://host:port/database",
            this.con = DriverManager.getConnection("jdbc:postgresql://"+PG_HOST+":5432/"+PG_DB,
                                              USER,
                                              PWD);
            //stmt = con.createStatement();
            //stmt.executeUpdate("create table personl99999(id integer, name varchar(128),birth timestamp without time zone)");
            //System.out.println(new java.util.Date());
            //stmt.executeUpdate("insert into personl99999 values(1,'O.MeuNome','"+new java.util.Date()+"')");
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Problems setting the connection");
        }
    }
    public List list_store_products(String store_id)throws Exception{
        List <String> list=new <String> ArrayList();
        try {
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM stock WHERE store_id="+store_id+";");
            ResultSetMetaData rsmd = rs.getMetaData();
            //int columnsNumber = rsmd.getColumnCount();
            list.add("Produto   Quantidade");
            while (rs.next()) {
                java.sql.Statement stmt_temp = con.createStatement();
                ResultSet temp;
                //System.out.println(rs.getString("product_id"));
                String id=rs.getString("product_id");
                String quantidade=rs.getString("quantity");
                temp=stmt_temp.executeQuery("SELECT * FROM product WHERE id="+id+";");
                //System.out.println(temp.getString("name"));
                temp.next();
                list.add(temp.getString("name")+"   "+quantidade);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public String helloTo(String name){
        return "Hello "+name;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }
    /*
    public static void main ( String args[] ) throws Exception
    {
        
    }
    */
}
