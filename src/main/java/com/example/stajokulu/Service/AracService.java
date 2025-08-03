package com.example.stajokulu.Service;

import com.example.stajokulu.Model.Dto.Arac.AracUpdateDto;
import com.example.stajokulu.Model.Entity.AracEntity;
import com.example.stajokulu.Repository.AracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AracService {

    @Autowired
    private AracRepository aracRepository;

    public List<AracEntity> getAllVehicles() {
        return aracRepository.findAll();
    }

    public List<AracEntity> getVehicleById(String aracKodu){
        return aracRepository.findByAracKodu(aracKodu);
    }

    public List<AracEntity> getVehicleByColor(String renkKodu){
        return aracRepository.findByRenkKodu(renkKodu);
    }

    public List<AracEntity> getVehicleByHp(Double motorHacmi){
        return aracRepository.findByMotorHacmi(motorHacmi);
    }

    public boolean saveVehicle(AracEntity arac){
        try {
            aracRepository.save(arac);
            return true;
        } catch (Exception e) {
            System.out.println("HATA GERÇEKLEŞTİ: " + e.getMessage());
            return false;
        }
    }

    public AracEntity updateVehicle(String aracKodu, AracUpdateDto updateDto){
        Optional<AracEntity> optionalArac = aracRepository.findById(aracKodu);
        if (optionalArac.isPresent()) {
            AracEntity existing = optionalArac.get();
            if (updateDto.getAracAdi() != null) existing.setAracAdi(updateDto.getAracAdi());
            if (updateDto.getMotorHacmi() != null) existing.setMotorHacmi(updateDto.getMotorHacmi());
            if (updateDto.getRenkKodu() != null) existing.setRenkKodu(updateDto.getRenkKodu());
            return aracRepository.save(existing);
        }
        return null;
    }

    public boolean deleteAracById(String aracKodu){
        try {
            Optional<AracEntity> optionalArac = aracRepository.findById(aracKodu);
            if (optionalArac.isPresent()) {
                aracRepository.delete(optionalArac.get());
                return true;
            }
            return false;
        } catch (Exception exception){
            System.out.println("SİLME İŞLEMİ YAPILIRKEN HATA: " + exception.getMessage());
            return false;
        } finally {
            System.out.println("SİLME İŞLEMİ TAMAMLANDI");
        }
    }
}
