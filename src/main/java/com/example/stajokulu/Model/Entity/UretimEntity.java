package com.example.stajokulu.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "URETIM")
public class UretimEntity {

    @Id
    @Column(name="URETIMSERINO")
    private String uretimSeriNo;

    @Column(name="URETIM_TARIHI")
    private String uretimTarihi;
    
    @Column(name="ARAC_KODU")
    private String aracKodu;

    @Column(name="URETIM_MALIYETI")
    private Double uretimMaliyeti;
    

}
