package com.project.so2.repos;

import com.project.so2.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Long>{
    
}
