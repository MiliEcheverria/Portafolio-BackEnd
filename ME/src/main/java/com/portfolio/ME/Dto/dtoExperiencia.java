package com.portfolio.ME.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String empE;
    @NotBlank
    private String descripcionE;
    @NotBlank 
    private String PeriodoE;
    private String imgE;

    //Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String empE, String descripcionE, String PeriodoE, String imgE) {
        this.nombreE = nombreE;
        this.empE = empE;
        this.descripcionE = descripcionE;
        this.PeriodoE = PeriodoE;
        this.imgE = imgE;
    }

    
    //Getters and Setters

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
        return PeriodoE;
    }

    public void setPeriodoE(String PeriodoE) {
        this.PeriodoE = PeriodoE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    
}