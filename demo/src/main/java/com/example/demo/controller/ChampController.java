package com.example.demo.controller;

import com.example.demo.dto.ChampDto;
import com.example.demo.entities.Champ;
import com.example.demo.services.ChampServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Champs")
@CrossOrigin
public class ChampController {
    @Autowired
    private ChampServiceImpl champService;

    @GetMapping("/lister")
    public ResponseEntity<?>findAllChamps() {
        return champService.findAllChamp();
        }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ChampDto champ) {
        return champService.save(champ);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return champService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ) {
        return champService.delete(id);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Champ champ){
        return  champService.modifier(champ);}

}
