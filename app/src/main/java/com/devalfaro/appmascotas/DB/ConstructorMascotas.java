package com.devalfaro.appmascotas.DB;

import android.content.ContentValues;
import android.content.Context;

import com.devalfaro.appmascotas.R;
import com.devalfaro.appmascotas.pojo.FavoritosPojo;
import com.devalfaro.appmascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 19/1/2017.
 */
public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {


        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodosLasMascotas();
    }



    public ArrayList<Mascotas> ver3mascotas(){
        BaseDatos db = new BaseDatos(context);
        insertar3Mascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertar3Mascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Boxer");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.boxer_dog_animal_15972);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Chihuaha");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.chihuahua_bone_dog_animal_15961);

        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Corgi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.corgi_dog_animal_15971);

        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues  contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOSTA,mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascotas);
    }


}
