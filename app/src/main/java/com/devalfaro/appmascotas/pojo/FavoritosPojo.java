package com.devalfaro.appmascotas.pojo;

/**
 * Created by Dev.Alfaro on 15/1/2017.
 */
public class FavoritosPojo {
    public String valoracion;
    public int foto;

    public FavoritosPojo(String valoracion, int foto) {
        this.valoracion = valoracion;
        this.foto = foto;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
