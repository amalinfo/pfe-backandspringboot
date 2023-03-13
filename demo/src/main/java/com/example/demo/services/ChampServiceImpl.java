package com.example.demo.services;

import com.example.demo.dto.ChampDto;
import com.example.demo.entities.Champ;
import com.example.demo.repositories.AppUserRepo;
import com.example.demo.repositories.Champ_Repository;
import com.example.demo.validations.ObjectValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChampServiceImpl implements ChampService {
    final private Champ_Repository champ_repository;
    final private AppUserRepo AppUserRepo;
    private final ObjectValidators<ChampDto> objectsValidator;


    @Override
    public ResponseEntity<?> save(ChampDto champDto) {
     Champ champ=new Champ(null,champDto.getNom(),champDto.getNumero(),champDto.getAdresse(),
             champDto.getDate_ajout(),AppUserRepo.findById(champDto.getUserId()).get(),null );
        return ResponseEntity.ok(champ_repository.save(champ));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        champ_repository.deleteById(id);
        return ResponseEntity.ok("delete");
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
    Optional<Champ>champ=champ_repository.findById(id);
    if (champ.isPresent()){
        return ResponseEntity.ok(champ.get());
    }
    return ResponseEntity.ok("champ Not Found");
    }

    @Override
    public ResponseEntity<?> findAllChamp() {
        return ResponseEntity.ok(champ_repository.findAll());
    }

    @Override
    public ResponseEntity<?> modifier(Champ champ) {
        Optional<Champ> champ1= champ_repository.findById(champ.getId());
        if(champ1.isPresent()){
         champ_repository.save(champ);
            return ResponseEntity.ok(champ);
        }
        else {
            return ResponseEntity.ok("champ not found");
        }
    }
    }


