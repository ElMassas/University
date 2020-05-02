package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductsByStore implements Serializable{

    private List<String> product;
    private List<Integer> quantity;
    private String storeName;

    
    
    public ProductsByStore() {
        this.product = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }

    public ProductsByStore(List<String> product, List<Integer> quantity, String storeName) {
        this.product = product;
        this.quantity = quantity;
        this.storeName = storeName;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    } 

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public void addProduct(String productName){
        this.product.add(productName);
    }
 
    public void addQuantity(int quantity){
        this.quantity.add(quantity);
    }
    
    public String toString(){
        String outcome = "\nThe Store: " + this.storeName + "\n";
        for(int i = 0; i < this.quantity.size(); i++){
            outcome += "\nProduct-> " + this.product.get(i) + "| Quantity: " + this.quantity.get(i)   ;
        }
        return outcome;
    }
    
}
