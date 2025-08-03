package com.example.stajokulu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stajokulu.Model.Entity.SatisEntity;
 
@Repository
public interface SatisRepository extends JpaRepository<SatisEntity, String> {

    // List<SatisEntity> findAll(SatisEntity satisEntity); -> wrong implementation, findAll() already exists in JpaRepository and takes no parameters.
    
    //List<SatisEntity> findByProductName(String productName);

}
