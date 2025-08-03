package com.example.stajokulu.Repository;

import com.example.stajokulu.Model.Entity.AracEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AracRepository extends JpaRepository<AracEntity, String> {

    List<AracEntity> findAllByMotorHacmi(Double motorHacmi);
    List<AracEntity> findByAracKodu(String aracKodu);
    List<AracEntity> findByRenkKodu(String renkKodu);
    List<AracEntity> findByMotorHacmi(Double motorHacmi);

}
