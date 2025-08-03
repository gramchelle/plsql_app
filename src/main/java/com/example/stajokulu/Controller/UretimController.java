package com.example.stajokulu.Controller;

import com.example.stajokulu.Model.Dto.Uretim.UretimDto;
import com.example.stajokulu.Model.Entity.UretimEntity;
import com.example.stajokulu.Service.UretimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;

import java.util.List;

@RestController
@RequestMapping("/uretim")
public class UretimController {

    @Autowired
    private UretimService uretimService;

    @PostMapping("/save")
    public ResponseEntity<UretimEntity> saveUretim(@RequestBody UretimDto dto) {
        return new ResponseEntity<>(uretimService.saveUretim(dto), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UretimEntity>> getAll() {
        return new ResponseEntity<>(uretimService.getall(), HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{uretimSeriNo}")
    public ResponseEntity<Void> deleteById(@PathVariable String uretimSeriNo) {
        uretimService.deleteUretim(uretimSeriNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getbyid/{uretimSeriNo}")
    public ResponseEntity<UretimEntity> getUretimById(@PathVariable String uretimSeriNo) {
        UretimEntity entity = uretimService.getUretimById(uretimSeriNo);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{uretimSeriNo}")
    public ResponseEntity<UretimEntity> updateUretim(@PathVariable String uretimSeriNo, @RequestBody UretimDto dto) {
        UretimEntity updatedEntity = uretimService.updateUretim(uretimSeriNo, dto);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}