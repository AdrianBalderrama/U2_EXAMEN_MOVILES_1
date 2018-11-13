package com.example.wilson.eva2_examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inCapturar, inMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inCapturar = new Intent(this, Datos.class);
    }
    public void onClickCapturar(View v){
        startActivity(inCapturar);
    }

    public void onClickMostrar(View v){

        inMostrar = new Intent(this, Mostrar.class);
        startActivity(inMostrar);
    }

    public void onClickSalir(View view) {
        finish();
    }
}
