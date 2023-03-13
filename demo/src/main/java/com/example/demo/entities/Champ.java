package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Champ {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    private  Long numero;
    private String adresse;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date date_ajout;
   @ManyToOne
  private AppUser AppUser;
   @JsonIgnore

    @OneToMany(mappedBy = "champ")
    private List<Capteur> capteur;
}
