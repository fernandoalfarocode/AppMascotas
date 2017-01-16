package com.devalfaro.appmascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devalfaro.appmascotas.R;
import com.devalfaro.appmascotas.adapter.Mascota_Adapter;
import com.devalfaro.appmascotas.pojo.Mascotas;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Dev.Alfaro on 12/1/2017.
 */
public class RecyclerViewFragment extends Fragment{

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public Mascota_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.Recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),1);

        listaMascotas.setLayoutManager(glm);
        inicializaListaContactos();
        inicializarAdaptador();





        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void inicializaListaContactos(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Boxer",R.drawable.boxer_dog_animal_15972));
        mascotas.add(new Mascotas("Chihuaha",R.drawable.chihuahua_bone_dog_animal_15961));
        mascotas.add(new Mascotas("Corgi",R.drawable.corgi_dog_animal_15971));
        mascotas.add(new Mascotas("Haski",R.drawable.haski_dog_animal_15968));
        mascotas.add(new Mascotas("Labrador",R.drawable.labrador_dog_animal_15967));
        mascotas.add(new Mascotas("Pug",R.drawable.pug_dog_animal_15965));
        mascotas.add(new Mascotas("Russel",R.drawable.russel_dog_animal_15954));

    }

    public void inicializarAdaptador(){
        adapter = new Mascota_Adapter(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);
    }


}
