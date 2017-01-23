package com.devalfaro.appmascotas.DB;

/**
 * Created by Dev.Alfaro on 19/1/2017.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";



    public static final String TABLE_MASCOTAS_LIKES                  = "mascotas_like";
    public static final String TABLE_MASCOTAS_LIKES_ID               = "id";
    public static final String TABLE_MASCOTAS_LIKES_ID_MASCOSTA      = "id_mascota";
    public static final String TABLE_MASCOTAS_LIKES_NUMERO_LIKES     = "numero_likes";



}
