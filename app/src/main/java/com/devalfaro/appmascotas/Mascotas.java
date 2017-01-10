package com.devalfaro.appmascotas;

/**
 * Created by Dev.Alfaro on 10/1/2017.
 */
public class Mascotas {
    private String nombre;
    private int foto;

    public Mascotas(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
