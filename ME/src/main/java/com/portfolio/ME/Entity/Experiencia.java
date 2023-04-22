
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ME.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @NotNull
    private String nombreE;
    @NotNull
    private String empE;
    @NotNull
    private String descripcionE;
    @NotNull
    private String periodoE;
    private String imgE;
    
    //Constructres

    public Experiencia() {
    }

    public Experiencia(String nombreE, String empE, String descripcionE, String periodoE, String imgE) {
        this.nombreE = nombreE;
        this.empE = empE;
        this.descripcionE = descripcionE;
        this.periodoE = periodoE;
        this.imgE = imgE;
    }

  
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getEmpE() {
        return empE;
    }

    public void setEmpE(String empE) {
        this.empE = empE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(String periodoE) {
        this.periodoE = periodoE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    

   
    
    
}