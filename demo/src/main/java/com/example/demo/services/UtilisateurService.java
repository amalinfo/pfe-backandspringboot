package com.example.demo.services;

import com.example.demo.entities.AppUser;
import org.springframework.http.ResponseEntity;

public interface UtilisateurService {


  ResponseEntity <?>delete(Long id);
    ResponseEntity <?> findById(Long id);
    ResponseEntity <?> findAllAppUser();
    /*Integer countutilisateursByAge(Integer age);*/
    ResponseEntity <?> save(AppUser user);
    ResponseEntity<?> modifier(Long id,AppUser user);

}
