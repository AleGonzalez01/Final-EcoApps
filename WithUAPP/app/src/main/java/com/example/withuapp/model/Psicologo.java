package com.example.withuapp.model;

public class Psicologo {
    private String nombre;
    private String apellido;

    public Psicologo() {
    }

    public Psicologo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
