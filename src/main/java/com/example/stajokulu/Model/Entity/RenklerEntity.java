package com.example.stajokulu.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ARAC_RENKLERI")
public class RenklerEntity {

    @Id
    @Column(name = "RENK_KODU")
    private String renkKodu;

    @Column(name = "RENK_ADI")
    private String renkAdi;
}
