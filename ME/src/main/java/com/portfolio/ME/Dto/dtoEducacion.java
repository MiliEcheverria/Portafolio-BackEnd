package com.portfolio.ME.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank 
    private String PeriodoE;
    private String imgE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String PeriodoE, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.PeriodoE = PeriodoE;
        this.imgE = imgE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
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