package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Capteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String nom;
    private Long numero;
    private String modelecapteur;
    private String poidcapteur;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateUtilisation;
    @JsonFormat(pattern = "yyyy-mm-dd")

    private Date dateFabrication;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateExpiration;
    @ManyToOne
    private Champ champ;
}
