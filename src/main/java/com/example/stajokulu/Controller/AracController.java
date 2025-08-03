package com.example.stajokulu.Controller;

import com.example.stajokulu.Model.Dto.Arac.*;
import com.example.stajokulu.Model.Entity.AracEntity;
import com.example.stajokulu.Service.AracService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arac")
public class AracController {

    @Autowired
    private AracService aracService;

    @GetMapping("/")
    public String welcomeuser(){
        return "Arac sayfasına hoş geldiniz!";
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AracEntity>> getAllVehicles() {
        List<AracEntity> vehicles = aracService.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{aracKodu}")
    public ResponseEntity<List<AracEntity>> getVehicleById(@PathVariable String aracKodu) {
        List<AracEntity> arac = aracService.getVehicleById(aracKodu);
        if (arac.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arac, HttpStatus.OK);
    }

    @GetMapping("/getbycolor/{renkKodu}")
    public ResponseEntity<List<AracEntity>> getVehicleByColor(@PathVariable String renkKodu) {
        List<AracEntity> arac = aracService.getVehicleByColor(renkKodu);
        if (arac.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arac, HttpStatus.OK);
    }
    
    @GetMapping("/getbyhp/{motorHacmi}")
    public ResponseEntity<List<AracEntity>> getVehicleByHp(@PathVariable Double motorHacmi) {
        List<AracEntity> arac = aracService.getVehicleByHp(motorHacmi);
        if (arac.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arac, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveVehicleWithDto(
            @RequestBody AracUpdateDto aracDto,
            @RequestParam(required = false) String aracKodu
    ) {
        if (aracKodu == null || aracKodu.isEmpty()) {
            aracKodu = UUID.randomUUID().toString();
        }

        AracEntity entity = new AracEntity();
        entity.setAracKodu(aracKodu);
        entity.setAracAdi(aracDto.getAracAdi());
        entity.setMotorHacmi(aracDto.getMotorHacmi());
        entity.setRenkKodu(aracDto.getRenkKodu());

        boolean success = aracService.saveVehicle(entity);

        if (success) {
            return new ResponseEntity<>("Araç başarıyla kaydedildi", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Araç kaydedilemedi", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{aracKodu}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String aracKodu) {
        boolean success = aracService.deleteAracById(aracKodu);
        if (success) {
            return new ResponseEntity<>("Araç başarıyla silindi", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Araç silinemedi", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{aracKodu}")
    public ResponseEntity<AracEntity> updateVehicle(
            @PathVariable String aracKodu,
            @RequestBody AracUpdateDto updateDto) {
        
        AracEntity updatedArac = aracService.updateVehicle(aracKodu, updateDto);
        
        if (updatedArac == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(updatedArac, HttpStatus.OK);
    }

}
