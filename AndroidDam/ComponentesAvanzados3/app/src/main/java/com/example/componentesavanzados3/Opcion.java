package com.example.componentesavanzados3;

//Opcion a elegir

import android.widget.CheckBox;

public class Opcion {

    //Atributos de la opcion
    private String titulo;
    private CheckBox checkBox;
    private int icono;

    public Opcion(String titulo, CheckBox checkBox, int icono) {
        this.setTitulo(titulo);
        this.setCheckBox(checkBox);
        this.setIcono(icono);
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if(titulo.isEmpty())
            this.titulo = "Otro";
        else
            this.titulo = titulo;
    }

    public CheckBox getCheckBox() { return checkBox; }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
