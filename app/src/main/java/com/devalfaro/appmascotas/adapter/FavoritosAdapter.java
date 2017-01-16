package com.devalfaro.appmascotas.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devalfaro.appmascotas.R;
import com.devalfaro.appmascotas.pojo.FavoritosPojo;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 15/1/2017.
 */
public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder>{
    ArrayList<FavoritosPojo> favoritos;

    public FavoritosAdapter(ArrayList<FavoritosPojo> favoritos, FragmentActivity activity){
        this.favoritos = favoritos;
    }


    @Override
    public FavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_rate,parent,false);
        return new FavoritosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoritosViewHolder holder, int position) {
        FavoritosPojo favoritospojo = favoritos.get(position);
        holder.valoracion.setText(favoritospojo.getValoracion());
        holder.imgFavorita.setImageResource(favoritospojo.getFoto());
    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }

    public static class FavoritosViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFavorita;
        private TextView valoracion;

        public FavoritosViewHolder(View itemView) {
            super(itemView);
            imgFavorita = (ImageView) itemView.findViewById(R.id.imgFotoFav);
            valoracion = (TextView) itemView.findViewById(R.id.valoracion_mascota);

        }
    }

}
