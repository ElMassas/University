package model;

import java.io.Serializable;


public class Product implements Serializable{
    
    private long id;
    private String name;

    public Product() {
    }
    
    public Product(final long id, final String name){
        this.id=id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
