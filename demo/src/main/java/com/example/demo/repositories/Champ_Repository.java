package com.example.demo.repositories;

import com.example.demo.entities.Champ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Champ_Repository extends JpaRepository<Champ,Long> {
 /* Champ findByNom (String name );*/
}
