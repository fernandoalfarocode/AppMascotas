package com.devalfaro.appmascotas.fragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devalfaro.appmascotas.R;
import com.devalfaro.appmascotas.adapter.FavoritosAdapter;
import com.devalfaro.appmascotas.pojo.FavoritosPojo;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Favoritos extends Fragment {

    ArrayList<FavoritosPojo> mascotas;
    private RecyclerView listaFavoritos;
    public FavoritosAdapter miadaptador;

    public Favoritos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favoritos,container,false);
        // Inflate the layout for this fragment
        listaFavoritos = (RecyclerView) v.findViewById(R.id.Recycler_view_favs);

        GridLayoutManager grid = new GridLayoutManager(getActivity(),3);

        listaFavoritos.setLayoutManager(grid);



        inicializaMascotasFavoritas();
        inicializarAdaptadorFavoritos();
        return v;


    }
    public void inicializaMascotasFavoritas(){

        mascotas = new ArrayList<FavoritosPojo>();

        mascotas.add(new FavoritosPojo("2",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("3",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("4",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("5",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("6",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("1",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("3",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("9",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("10",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("2",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("3",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("4",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("5",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("6",R.drawable.favorito));
        mascotas.add(new FavoritosPojo("7",R.drawable.favorito));
    }

    public void inicializarAdaptadorFavoritos(){
         miadaptador = new FavoritosAdapter(mascotas,getActivity());
        listaFavoritos.setAdapter(miadaptador);
    }

}
