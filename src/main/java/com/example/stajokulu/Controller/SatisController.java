package com.example.stajokulu.Controller;

import com.example.stajokulu.Model.Dto.Satis.*;
import com.example.stajokulu.Model.Entity.SatisEntity;
import com.example.stajokulu.Service.SatisService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satis")
@RequiredArgsConstructor
public class SatisController {

    private final SatisService satisService;

    @PostMapping("/save")
    public ResponseEntity<SatisEntity> saveSatis(@RequestBody SatisDto dto) {
        return new ResponseEntity<>(satisService.saveSatis(dto), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<SatisEntity>> getAllSatislar() {
        return new ResponseEntity<>(satisService.getAllSatislar(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<SatisEntity> getSatisById(@PathVariable String id) {
        SatisEntity satis = satisService.getSatisById(id);
        return satis != null ? ResponseEntity.ok(satis) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSatis(@PathVariable String id) {
        satisService.deleteSatis(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SatisEntity> updateSatis(@PathVariable String id, @RequestBody SatisDto dto) {
        SatisEntity updated = satisService.updateSatis(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
