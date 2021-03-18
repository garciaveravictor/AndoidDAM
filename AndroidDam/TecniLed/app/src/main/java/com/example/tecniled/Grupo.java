package com.example.tecniled;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private String ubicacion;
    private List<Foco> listaFoco;

    public Grupo(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        listaFoco  = new ArrayList<Foco>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void addFoco(Foco foco){
        listaFoco.add(foco);
    }

    public boolean eliminarFoco(Foco foco){
        if(existeFoco(foco))
            listaFoco.remove(foco);
        else
            return false;

        return true;
    }

    public boolean existeFoco(Foco foco){
        if (listaFoco.isEmpty())
            return  false;
        else if (listaFoco.contains(foco))
            return true;
        else
            return false;
    }
}
