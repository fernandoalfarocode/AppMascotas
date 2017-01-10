package com.devalfaro.appmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import javax.crypto.Mac;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.Recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(this,1);

        listaMascotas.setLayoutManager(glm);
        inicializaListaContactos();
        inicializarAdaptador();
    }

    public Mascota_Adapter adapter;

    public void inicializarAdaptador(){
        adapter = new Mascota_Adapter(mascotas,this);
        listaMascotas.setAdapter(adapter);
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

    public void irMascotasFavoritas(View v){
        Intent intent = new Intent(this,MascotasFavoritas.class);
        startActivity(intent);

    }
}

