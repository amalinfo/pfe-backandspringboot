package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@AllArgsConstructor
@Data
public class ChampDto {
 private Long userId;
    @NotBlank
    @NotEmpty(message = "nom doit etre not empty")
    @Size(max = 10 , min = 1)
    private String nom;
    @NotBlank
    @NotEmpty(message = "nom doit etre not empty")
    @Size(max = 4 , min = 1)
    private Long numero;
    @NotBlank
    private String adresse;
    @NotBlank
    private Date date_ajout;


    }



