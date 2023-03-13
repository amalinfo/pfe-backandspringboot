package com.example.demo.services;

import com.example.demo.dto.CapteurDto;
import com.example.demo.entities.Capteur;
import com.example.demo.exception.CapteurNotFoundExcep;
import org.springframework.http.ResponseEntity;

public interface CapteurService{
    ResponseEntity<?> save(CapteurDto capteurDto);
    ResponseEntity<?> delete(Long id) throws CapteurNotFoundExcep;
    ResponseEntity<?> findById(Long id) throws CapteurNotFoundExcep;
    ResponseEntity<?>findAllCapteur();
    /*void addChampCapteur(String nameChamp, String nameCapteur);*/
    ResponseEntity<?> modifier(Capteur capteur);
}
