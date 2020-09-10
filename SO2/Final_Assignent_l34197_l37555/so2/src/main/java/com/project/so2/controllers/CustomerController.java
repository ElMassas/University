package com.project.so2.controllers;

import com.project.so2.models.Customer;
import com.project.so2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    
    @Autowired
    private CustomerService customerservice;
    
    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer){
        this.customerservice.saveCostumer(customer);
    }
    
    //|Browser| <> Front-End <> API <> Servidor
    
    
    @PostMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        this.customerservice.saveCostumer(customer);
    }
    
}
