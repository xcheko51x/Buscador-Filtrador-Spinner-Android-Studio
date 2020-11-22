package com.xcheko51x.spinnerfiltrador;

import java.io.Serializable;

public class Trabajadores implements Serializable {

    String nombre;
    String area;

    public Trabajadores(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
