package com.example.demo.services;

import com.example.demo.entities.AppUser;
import com.example.demo.repositories.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor //injection de dependence
public class UtilisateurServiceImpl implements UtilisateurService {
    private final AppUserRepo appUserRepo;
    private final  BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public ResponseEntity<?> delete(Long id) {
        appUserRepo.deleteById(id);
        return ResponseEntity.status(200).body("delete");

    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<AppUser> user = appUserRepo.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(200).body(user.get());

        } else
            return ResponseEntity.status(200).body("User Not Found");
    }

    @Override
    public ResponseEntity<?> findAllAppUser() {
        return ResponseEntity.ok().body(appUserRepo.findAll());
    }

    @Override
    public ResponseEntity<?> save(AppUser user) {
        if (appUserRepo.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(400).body(" user exsit");
        }
        else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return  ResponseEntity.ok(appUserRepo.save(user));

        }

    }

    @Override
    public ResponseEntity<?> modifier( Long id ,AppUser user) {
        Optional<AppUser> user1= appUserRepo.findById(id);
        log.info(user1.get().toString());
        if(user1.isPresent()){
            AppUser up=user1.get();
            up.setEmail(user.getEmail());
            up.setAge(user.getAge());
            up.setCin(user.getCin());
            up.setNom(user.getNom());
            up.setPrenom(user.getPrenom());
            up.setTelephone(user.getTelephone());
            appUserRepo.save(up);
            return ResponseEntity.ok(up);
        }
        else {
            return ResponseEntity.ok("user not found");
        }
    }

}
