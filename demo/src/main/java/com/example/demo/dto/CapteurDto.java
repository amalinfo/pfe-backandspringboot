package com.example.demo.dto;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@Data

public class CapteurDto {
    private  Long idchamp;
    private String nom;
    private Long numero;
    private  String modelecapteur;
    private  String poidcapteur;
    private Date dateUtilisation;
    private Date dateFabrication;
    private Date dateExpiration;
   }
