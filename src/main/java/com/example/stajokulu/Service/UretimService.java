package com.example.stajokulu.Service;

import com.example.stajokulu.Model.Dto.Uretim.UretimDto;
import com.example.stajokulu.Model.Entity.UretimEntity;
import com.example.stajokulu.Repository.UretimRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UretimService {

    private final UretimRepository uretimRepository;

    public UretimEntity saveUretim(UretimDto dto){
        UretimEntity uretim = new UretimEntity();
        uretim.setUretimSeriNo(dto.getUretimSeriNo());
        uretim.setUretimTarihi(dto.getUretimTarihi());
        uretim.setAracKodu(dto.getAracKodu());
        uretim.setUretimMaliyeti(dto.getUretimMaliyeti());
        return uretimRepository.save(uretim);
    }

    public List<UretimEntity> getall() {
        return uretimRepository.findAll();
    }

    public void deleteUretim(String uretimSeriNo) {
        uretimRepository.deleteById(uretimSeriNo);
    }

    public UretimEntity getUretimById(String uretimSeriNo) {
        return uretimRepository.findById(uretimSeriNo).orElse(null);
    }

    public UretimEntity updateUretim(String uretimSeriNo, UretimDto dto) {
        UretimEntity uretim = getUretimById(uretimSeriNo);
        if (uretim == null) return null;

        uretim.setUretimTarihi(dto.getUretimTarihi());
        uretim.setAracKodu(dto.getAracKodu());
        uretim.setUretimMaliyeti(dto.getUretimMaliyeti());

        return uretimRepository.save(uretim);
    }
}