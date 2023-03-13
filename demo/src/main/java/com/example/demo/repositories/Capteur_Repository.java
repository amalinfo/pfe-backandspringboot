package com.example.demo.repositories;

import com.example.demo.entities.Capteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Capteur_Repository extends JpaRepository<Capteur,Long> {
 /*Capteur findByName(String name);*/
}
