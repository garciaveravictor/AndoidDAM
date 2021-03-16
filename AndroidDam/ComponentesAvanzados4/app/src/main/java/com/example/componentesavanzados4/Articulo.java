package com.example.componentesavanzados4;

public class Articulo {
    private String nombre;
    private boolean comprado;

    public Articulo(String nombre){
        this.setNombre(nombre);
        setComprado(false);
    }

    public void setNombre (String nombre){
        if(nombre.isEmpty())
            this.nombre = "Otro";
        else
            this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
