package com.project.so2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Store")
@Table(name = "store")
@SequenceGenerator(name = "store_id")
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_id")
    @Column(name = "id")
    private long id;
    
    @Column(name = "store_owner")
    private String storeOwner;
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "store_size")
    private String storeSize;

    public Store() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreSize() {
        return storeSize;
    }

    public void setStoreSize(String storeSize) {
        this.storeSize = storeSize;
    }
    
    
}
