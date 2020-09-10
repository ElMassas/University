package com.project.so2.repos;

import com.project.so2.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store,Long>{
    
}
