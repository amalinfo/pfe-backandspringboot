package com.example.demo.services;

import com.example.demo.dto.ChampDto;
import com.example.demo.entities.Champ;
import org.springframework.http.ResponseEntity;

public interface ChampService {
ResponseEntity<?> save(ChampDto champDto);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?>findAllChamp();
    ResponseEntity<?> modifier(Champ champ);

}
