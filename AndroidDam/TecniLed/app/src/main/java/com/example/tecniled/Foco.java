package com.example.tecniled;

import java.io.Serializable;
import java.util.Objects;

public class Foco implements Serializable {

    private String nombre;
    private String marca;
    private int direccion;
    private int canales;
    private int dmx;

    public Foco(String nombre, String marca, int direccion, int canales, int dmx) {
        this.nombre = nombre;
        this.marca = marca;
        this.direccion = direccion;
        this.canales = canales;
        this.dmx = dmx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foco foco = (Foco) o;
        return direccion == foco.direccion &&
                canales == foco.canales &&
                dmx == foco.dmx &&
                Objects.equals(nombre, foco.nombre) &&
                Objects.equals(marca, foco.marca);
    }

}
