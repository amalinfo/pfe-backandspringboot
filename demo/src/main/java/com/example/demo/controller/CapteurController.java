package com.example.demo.controller;

import com.example.demo.dto.CapteurDto;
import com.example.demo.entities.Capteur;
import com.example.demo.services.CapteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Capteur")
@CrossOrigin
public class CapteurController {
    @Autowired
    private CapteurServiceImpl capteurService;
    @GetMapping("/lister")
    public ResponseEntity<?> findAllCapteur() {
        return capteurService.findAllCapteur();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CapteurDto capteur) {
        return capteurService.save(capteur);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return capteurService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ) {
        return capteurService.delete(id);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Capteur capteur){
        return capteurService.modifier(capteur);}
}
