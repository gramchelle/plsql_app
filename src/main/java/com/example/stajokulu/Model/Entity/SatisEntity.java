package com.example.stajokulu.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SATIS")
public class SatisEntity {

    @Id
    @Column(name = "URETIMSERINO")
    private String uretimSeriNo;
    
    @Column(name = "SATIS_TARIHI")
    private String satisTarihi;

    @Column(name = "ARAC_KODU")
    private String aracKodu;

    @Column(name = "SATIS_TUTARI")
    private Double satisTutari;

}