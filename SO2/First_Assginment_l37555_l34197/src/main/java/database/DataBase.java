package database;

import dto.ProductsByStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Necessity;

import model.Store;
import model.User;

public class DataBase implements java.rmi.Remote {

    public Connection con;
    public Statement stmt;

    public DataBase(String PG_HOST, String PG_DB, String USER, String PASSWORD) {

        this.con = null;
        this.stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + PG_HOST + ":5432/" + PG_DB, USER, PASSWORD);
            this.stmt = this.con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problemas a iniciar a connection");
        }
    }

    public int getId(String target, String name) {
        int id = 0;
        final String getIdsQuery = "SELECT id FROM " + target + " WHERE name = '" + name + "';";

        try {
            ResultSet result = stmt.executeQuery(getIdsQuery);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getIdFromUserEmail(String userEmail) {
        int id = 0;
        final String getIdsQuery = "SELECT id FROM user_p WHERE email = '" + userEmail + "';";

        try {
            ResultSet result = stmt.executeQuery(getIdsQuery);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void deleteNecessities(String userEmail) {
        int userId = getIdFromUserEmail(userEmail);
        final String deleteNecessitiesQuery = "DELETE FROM necessity WHERE email = '" + userEmail + "' AND store_id IS NOT NULL";
        
        try {
            stmt.executeUpdate(deleteNecessitiesQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //+++++++++++++++++++++++++++++
    //Validations
    //+++++++++++++++++++++++++++++
    public boolean checkUserExistance(String userEmail) {
        int userId = getIdFromUserEmail(userEmail);

        if (userId == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkStoreExistance(String storeName) {
        int storeId = getId("store", storeName);

        if (storeId == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkProductExistance(String productName) {
        int productId = getId("product", productName);

        if (productId == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkNecessityExistance(String productName) {
        int productId = getId("product", productName);
        
        if (productId == 0) {
            return false;
        }
        
        final String checkNecessityExistanceQuery = "SELECT product_id FROM necessity WHERE product_id = " + productId + "";
        
        try {
            ResultSet result = stmt.executeQuery(checkNecessityExistanceQuery);
            if (!result.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public boolean checkNecessityExistanceForUser(String productName, String userEmail) {
        int productId = getId("product", productName);
        int userId = getIdFromUserEmail(userEmail);
        
        if (productId == 0) {
            return false;
        }
        
        final String checkNecessityExistanceQuery = "SELECT product_id, user_id FROM necessity WHERE product_id = " + productId + " AND user_id = "+ userId +"";
        
        try {
            ResultSet result = stmt.executeQuery(checkNecessityExistanceQuery);
            if (result.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    

    //+++++++++++++++++++++++++++++
    //Calls from Service start here
    //+++++++++++++++++++++++++++++
    public boolean registerNecessity(Necessity necessity) {
        int idProduct = getId("product", necessity.getProductName());
        int idUser = getIdFromUserEmail(necessity.getUserEmail());
        
        if(!checkNecessityExistanceForUser(necessity.getProductName(), necessity.getUserEmail()))
            return false;

        final String registerNecessityQuery = "INSERT INTO necessity (user_id, product_id, store_id ) VALUES (" + idUser + "," + idProduct + ", null);";

        try {
            stmt.executeUpdate(registerNecessityQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //doesn't need validation
    public ArrayList<String> getNecessityList() {
        ArrayList<String> necessityList = new ArrayList<>();
        final String getNecessityListQuery = "SELECT DISTINCT name FROM product RIGHT JOIN necessity AS s ON id = s.product_id;";

        try {
            ResultSet result = stmt.executeQuery(getNecessityListQuery);
            while (result.next()) {
                necessityList.add(result.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return necessityList;

    }
    
    //doesn't need validation
    public ArrayList<String> checkStores() {
        final String checkProductByStoreQuery = "SELECT name FROM store;";
        ArrayList<String> stores = new ArrayList<>();

        try {
            ResultSet result = stmt.executeQuery(checkProductByStoreQuery);
            while (result.next()) {
                stores.add(result.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stores;
    }

    //check if size is 0 and return some 
    public ProductsByStore getProductListByStore(Store store) {
        ProductsByStore productsByStore = new ProductsByStore();
        productsByStore.setStoreName(store.getName());
        final String getProductIdListQuery = "SELECT name, quantity  FROM product INNER JOIN (SELECT product_id, quantity FROM stock WHERE store_id IN (SELECT id FROM store WHERE name = '" + store.getName() + "')) AS s ON id = s.product_id;";//lower ammt connect to DB

        try {
            ResultSet result = stmt.executeQuery(getProductIdListQuery);
            while (result.next()) {
                productsByStore.addProduct(result.getString("name"));
                productsByStore.addQuantity(result.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productsByStore;
    }

    public boolean signalProduct(String productName, String storeName) {
        int storeId = getId("store", storeName);
        int productId = getId("product", productName);
        
        if (!checkStoreExistance(storeName) && !checkProductExistance(productName)){
            System.out.println("error");
            return false;
        }
        
        
       
        final String signalProductFoundQuery = "UPDATE necessity SET store_id = " + storeId + " WHERE product_id = " + productId + ";";

        try {
            stmt.executeUpdate(signalProductFoundQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<Necessity> checkNecessityListForUser(String userEmail) {
        int userId = getIdFromUserEmail(userEmail);
        ArrayList<Necessity> userNecessities = new ArrayList<Necessity>();
        final String getUsersNecessitiesQuery = "SELECT p.name AS product_name, t1.name AS store_name FROM product AS p RIGHT JOIN ((SELECT store_id, product_id FROM necessity WHERE user_id = " + userId + " AND store_id IS NOT NULL) AS n LEFT JOIN store AS s ON n.store_id = s.id) AS t1 ON t1.product_id = p.id;";

        try {
            ResultSet result = stmt.executeQuery(getUsersNecessitiesQuery);
            while (result.next()) {
                userNecessities.add(new Necessity(result.getString("store_name"), result.getString("product_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        deleteNecessities(userEmail);
        return userNecessities;

    }

    public String registerUser(User user) {
        if (checkUserExistance(user.getEmail())) {
            return "\nWelcome back!";
        } else {
            final String registerUserQuery = "INSERT INTO user_p (name, email) VALUES ('" + user.getName() + "','" + user.getEmail() + "');";

            try {
                stmt.executeUpdate(registerUserQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "\nYou have been registerd!";
        }
    }

    public String changeUserName(User user) {
        if (!checkUserExistance(user.getEmail())) {
            return ("\nUser does not exist!");
        } else {
            int userId = getIdFromUserEmail(user.getEmail());
            final String changeUserNameQuery = "UPDATE user_p SET name = " + user.getName() + " WHERE id= " + userId + ";";

            try {
                stmt.executeUpdate(changeUserNameQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "\nYour name has been updated!";
        }
    }

    public String changeUserEmail(String userEmail) {
        if (!checkUserExistance(userEmail)) {
            return ("\nUser does not exist!");
        } else {
            int userId = getIdFromUserEmail(userEmail);
            final String changeUserEmailQuery = "UPDATE user_p SET email = " + userEmail + " WHERE id= " + userId + ";";

            try {
                stmt.executeUpdate(changeUserEmailQuery);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "\nYour email has been updated!";
        }
    }

}
