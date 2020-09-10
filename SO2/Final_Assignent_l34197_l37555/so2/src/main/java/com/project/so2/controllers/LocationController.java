package com.project.so2.controllers;

import com.project.so2.models.Location;
import com.project.so2.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {
       
    @Autowired
    private LocationService locatonservice;
    
    @GetMapping("/check")
    public void checkStoreLocation(@RequestBody Location location){
        this.locatonservice.saveLocation(location);
    }
    
    @PostMapping("/insert")
    public void insertStoreLocation(@RequestBody Location location){
        this.locatonservice.saveLocation(location);
    }
    
    @PostMapping("/update")
    public void updateLocation(@RequestBody Location location){
        this.locatonservice.saveLocation(location);
    }
    
}
