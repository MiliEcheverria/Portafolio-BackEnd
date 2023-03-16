<<<<<<< HEAD
package com.portfolio.ME.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
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

    public void setDescricpionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

}
=======
package com.portfolio.ME.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
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

    public void setDescricpionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

}
>>>>>>> 51cfe50 (Mi primer commit)
