package com.example.wilson.eva2_examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Mostrar extends AppCompatActivity {
    //ListView of the Restaurants
    ListView lstVwRest;
    Intent cambiarEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        lstVwRest = findViewById(R.id.lstVwRest);
        lstVwRest.setAdapter(new ListAdapter(this, R.layout.lista_rest, DatosRestaurantes.lista));
        //Stars
        cambiarEstrellas = new Intent(this, Evaluar.class);
        lstVwRest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Onclick to Evaluar
                cambiarEstrellas.putExtra("posImg", position);
                startActivity(cambiarEstrellas);
                finish();
            }
        });
    }


}
