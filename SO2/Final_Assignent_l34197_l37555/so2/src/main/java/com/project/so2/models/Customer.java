package com.project.so2.models;

import com.project.so2.aux.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customer")
@SequenceGenerator(name = "customer_id")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
    @Column(name = "id")
    private long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role")    
    private Role role;//customer|admin|store_owner
    
    @Column(name = "mail", unique = true)
    private String mail;
    
    @Column(name = "name")
    private String name;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
