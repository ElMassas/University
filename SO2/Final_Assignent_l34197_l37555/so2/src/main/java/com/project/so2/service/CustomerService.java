package com.project.so2.service;

import com.project.so2.aux.Role;
import com.project.so2.models.Customer;
import com.project.so2.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    //create and update are different just from an api point of view
    public void saveCostumer(Customer customer){
        this.customerRepository.save(customer);
    }


    
}
