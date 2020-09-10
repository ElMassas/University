package com.project.so2.service;

import com.project.so2.models.Location;
import com.project.so2.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    //insert and update are different just from an api point of view
    public void saveLocation(Location location){
        this.locationRepository.save(location);
    }

    
}
