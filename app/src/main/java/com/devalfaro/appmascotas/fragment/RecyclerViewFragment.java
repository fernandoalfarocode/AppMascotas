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
import com.devalfaro.appmascotas.presentador.IRecyclerViewFragmentPresenter;
import com.devalfaro.appmascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 12/1/2017.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.Recycler_view);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),1);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public Mascota_Adapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        Mascota_Adapter adapter = new Mascota_Adapter(mascotas,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(Mascota_Adapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}
