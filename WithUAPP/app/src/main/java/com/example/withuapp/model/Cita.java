package com.example.withuapp.model;

import java.io.Serializable;

public class Cita implements Serializable {
    private String id;
    private String fecha;
    private String hora;
    private String nombrePsico;

    public Cita() {
    }

    public Cita(String id, String fecha, String hora, String nombrePsico) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombrePsico = nombrePsico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombrePsico() {
        return nombrePsico;
    }

    public void setNombrePsico(String nombrePsico) {
        this.nombrePsico = nombrePsico;
    }

    @Override
    public String toString() {
        return "Cita con "+nombrePsico+"\n"+fecha+" - "+hora;
    }
}
