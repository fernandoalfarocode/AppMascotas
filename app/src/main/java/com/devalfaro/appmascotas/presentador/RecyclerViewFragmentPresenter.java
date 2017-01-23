package com.devalfaro.appmascotas.presentador;

import android.content.Context;

import com.devalfaro.appmascotas.DB.ConstructorMascotas;
import com.devalfaro.appmascotas.adapter.Mascota_Adapter;
import com.devalfaro.appmascotas.fragment.IRecyclerViewFragmentView;
import com.devalfaro.appmascotas.fragment.RecyclerViewFragment;
import com.devalfaro.appmascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Dev.Alfaro on 19/1/2017.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.ver3mascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
