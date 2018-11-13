package com.example.wilson.eva2_examen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaImagenes extends AppCompatActivity {


    ListView lstVwSelec;
    Intent resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);

        lstVwSelec = findViewById(R.id.lstVwSelec);
        lstVwSelec.setAdapter(new AdaptadorImagenes(this, R.layout.selec_img_layout,
                DatosRestaurantes.lista));
        resultado = new Intent();
        lstVwSelec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bdl = new Bundle();
                bdl.putInt("ACCION", 1);
                bdl.putInt("IMGSELEC", DatosRestaurantes.lista.get(position).imgRest);
                resultado.putExtras(bdl);
                setResult(Activity.RESULT_OK,resultado);

                finish();
            }
        });

    }


}


