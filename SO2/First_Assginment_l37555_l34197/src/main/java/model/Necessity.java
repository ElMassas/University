package model;

import java.io.Serializable;

public class Necessity implements Serializable{
    
    private String userName;
    private String userEmail;
    private String storeName;
    private String productName;
    private int quantity;

    public Necessity() {
    }
    
    public Necessity(String storeName, String productName) {
        this.storeName = storeName;
        this.productName = productName;
    }
    
    public Necessity(String userName, String productName, int quantity) {
        this.userName = userName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    
    
}
