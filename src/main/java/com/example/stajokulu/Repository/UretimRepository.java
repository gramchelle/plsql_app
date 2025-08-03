package com.example.stajokulu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stajokulu.Model.Entity.UretimEntity;

@Repository
public interface UretimRepository extends JpaRepository<UretimEntity, String> {

    //List<UretimEntity> findAll(UretimEntity uretimEntity);

}
