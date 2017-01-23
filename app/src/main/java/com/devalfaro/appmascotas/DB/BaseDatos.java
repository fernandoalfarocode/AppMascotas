package com.devalfaro.appmascotas.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.devalfaro.appmascotas.pojo.FavoritosPojo;
import com.devalfaro.appmascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 19/1/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOSTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOSTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";


        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL(queryCrearTablaLikesMascotas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES);
        onCreate(sqLiteDatabase);
    }


    public ArrayList<Mascotas> obtenerTodosLasMascotas() {

        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db  = this.getWritableDatabase();

       Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_NUMERO_LIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOSTA + "=" + mascotaActual.getId();

            Cursor registroLike = db.rawQuery(queryLikes,null);
            if(registroLike.moveToNext()){
                mascotaActual.setLikes(registroLike.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }



    //LIKES

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES,null,contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascotas mascotas){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES +
                        " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOSTA + "=" +mascotas.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query,null);

        if(registro.moveToNext()){
            likes = registro.getInt(0);
        }

        db.close();

        return likes;
    }


    }
