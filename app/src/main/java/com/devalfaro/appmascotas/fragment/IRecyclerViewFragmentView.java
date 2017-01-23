package com.devalfaro.appmascotas.fragment;

import com.devalfaro.appmascotas.adapter.Mascota_Adapter;
import com.devalfaro.appmascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 19/1/2017.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public Mascota_Adapter crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(Mascota_Adapter adapter);
}
