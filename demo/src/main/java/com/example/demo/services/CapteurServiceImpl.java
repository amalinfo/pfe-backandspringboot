package com.example.demo.services;

import com.example.demo.dto.CapteurDto;
import com.example.demo.entities.Capteur;
import com.example.demo.repositories.Capteur_Repository;
import com.example.demo.repositories.Champ_Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CapteurServiceImpl implements CapteurService {

    private final Capteur_Repository capteur_repository;
    private final Champ_Repository champ_repository;

    @Override
    public ResponseEntity<?> save(CapteurDto capteurDto) {
        Capteur capteur=new Capteur(null,capteurDto.getNom(),capteurDto.getNumero(),capteurDto.getModelecapteur(),
                capteurDto.getPoidcapteur(),capteurDto.getDateUtilisation(),capteurDto.getDateFabrication(),
                capteurDto.getDateExpiration(),champ_repository.findById(capteurDto.getIdchamp()).get());
        return  ResponseEntity.ok(capteur_repository.save(capteur));
    }

    @Override
    public ResponseEntity<?> delete(Long id){
        capteur_repository.deleteById(id);
        return ResponseEntity.ok("delete");
    }

    @Override
    public ResponseEntity<?> findById(Long id){
        Optional<Capteur>capteur=capteur_repository.findById(id);
        if (capteur.isPresent()){
            return ResponseEntity.ok(capteur.get());
        }
        return ResponseEntity.ok("capteur Not Found");
    }

    @Override
    public ResponseEntity<?> findAllCapteur() {
        return ResponseEntity.ok(capteur_repository.findAll());
    }

    @Override
    public ResponseEntity<?> modifier(Capteur capteur) {
        Optional<Capteur> capteur1= capteur_repository.findById(capteur.getId());
        if(capteur1.isPresent()){
            capteur_repository.save(capteur);
            return ResponseEntity.ok(capteur);
        }
        else {
            return ResponseEntity.ok("capteur not found");
        }
    }

}
