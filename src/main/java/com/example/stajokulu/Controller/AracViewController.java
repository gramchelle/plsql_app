package com.example.stajokulu.Controller;

import com.example.stajokulu.Model.Entity.AracEntity;
import com.example.stajokulu.Service.AracService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AracViewController {

    private final AracService aracService;

    public AracViewController(AracService aracService) {
        this.aracService = aracService;
    }

    @GetMapping("/araclar")
    public String getAllVehicles(Model model) {
        List<AracEntity> aracListesi = aracService.getAllVehicles();
        model.addAttribute("araclar", aracListesi);
        return "araclar";
    }
}
