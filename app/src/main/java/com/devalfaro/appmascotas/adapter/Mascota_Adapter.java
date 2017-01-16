package com.devalfaro.appmascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devalfaro.appmascotas.pojo.Mascotas;
import com.devalfaro.appmascotas.R;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 10/1/2017.
 */
public class Mascota_Adapter extends RecyclerView.Adapter<Mascota_Adapter.MascotaViewHolder> {
    ArrayList<Mascotas> mascotas;
    Activity activity;


    public Mascota_Adapter(ArrayList<Mascotas> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public Mascota_Adapter.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        MascotaViewHolder.nombre.setText(mascota.getNombre());
        MascotaViewHolder.foto.setImageResource(mascota.getFoto());


    }

    @Override
    public int getItemCount() { return mascotas.size();}



    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private ImageView foto;

        public MascotaViewHolder(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombremascota);
            foto = (ImageView) itemView.findViewById(R.id.imgFoto);
        }
    }
}
