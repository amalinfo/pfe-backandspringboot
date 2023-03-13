package com.example.demo.controller;

import com.example.demo.entities.AppUser;
import com.example.demo.services.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurServiceImpl utilisateurService;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AppUser appUser) {
        return utilisateurService.save(appUser);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }
    @GetMapping("/lister")
    public ResponseEntity<?> findAllUtilisateurs() {
        return utilisateurService.findAllAppUser();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ) {
       return utilisateurService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody AppUser user){
        return  utilisateurService.modifier(id,user);}
    }




