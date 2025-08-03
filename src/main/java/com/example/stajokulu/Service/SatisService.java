package com.example.stajokulu.Service;

import com.example.stajokulu.Model.Dto.Satis.*;
import com.example.stajokulu.Model.Entity.SatisEntity;
import com.example.stajokulu.Repository.SatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SatisService {

    private final SatisRepository satisRepository;

    public SatisEntity saveSatis(SatisDto dto) {
        SatisEntity satis = new SatisEntity();
        satis.setUretimSeriNo(dto.getUretimSeriNo());
        satis.setSatisTarihi(dto.getSatisTarihi());
        satis.setAracKodu(dto.getAracKodu());
        satis.setSatisTutari(dto.getSatisTutari());
        return satisRepository.save(satis);
    }

    public List<SatisEntity> getAllSatislar() {
        return satisRepository.findAll();
    }

    public SatisEntity getSatisById(String id) {
        return satisRepository.findById(id).orElse(null);
    }

    public void deleteSatis(String id) {
        satisRepository.deleteById(id);
    }

    public SatisEntity updateSatis(String id, SatisDto dto) {
        SatisEntity satis = getSatisById(id);
        if (satis == null) return null;

        satis.setSatisTarihi(dto.getSatisTarihi());
        satis.setAracKodu(dto.getAracKodu());
        satis.setSatisTutari(dto.getSatisTutari());

        return satisRepository.save(satis);
    }
}
