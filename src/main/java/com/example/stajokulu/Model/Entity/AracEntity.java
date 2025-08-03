package com.example.stajokulu.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ARACLAR")
@Data
public class AracEntity {

    @Id
    @Column(name = "ARAC_KODU")
    private String aracKodu;

    @Column(name = "ARAC_ADI")
    private String aracAdi;

    @Column(name = "MOTOR_HACMI")
    private Double motorHacmi;

    @Column(name = "RENK_KODU")
    private String renkKodu;

}