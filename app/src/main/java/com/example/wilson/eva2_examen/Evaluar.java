package com.example.wilson.eva2_examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class Evaluar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView txtVwNombreEval, txtVwDescEval, txtVwDirTelEval;
    ImageView imgVwEval, imgVwEval1, imgVwEval2, imgVwEval3;
    SeekBar skBrEval;

    Intent getPosImg, volverMostrar;
    int posImgObtenida;
    List<DatosRestaurantes> listaEval = DatosRestaurantes.lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluar);
        txtVwNombreEval = findViewById(R.id.txtVwNombreEval);
        txtVwDescEval = findViewById(R.id.txtVwDescEval);
        txtVwDirTelEval = findViewById(R.id.txtVwDirTelEval);
        imgVwEval = findViewById(R.id.imgVwEval);
        imgVwEval1 = findViewById(R.id.imgVwEval1);
        imgVwEval2 = findViewById(R.id.imgVwEval2);
        imgVwEval3 = findViewById(R.id.imgVwEval3);
        skBrEval = findViewById(R.id.skBrEval);

        skBrEval.setOnSeekBarChangeListener(this);

        volverMostrar = new Intent(this, Mostrar.class);
        getPosImg = getIntent();
        //Value intent
        posImgObtenida = getPosImg.getIntExtra("posImg", 0);
        skBrEval.setProgress(listaEval.get(posImgObtenida).estrellasTot);
        imgVwEval.setImageResource(listaEval.get(posImgObtenida).imgRest);
        txtVwNombreEval.setText(listaEval.get(posImgObtenida).nombreRest);
        txtVwDescEval.setText(listaEval.get(posImgObtenida).descRest);
        txtVwDirTelEval.setText(listaEval.get(posImgObtenida).dirytelRest);
        rellenarImagenes();
    }
        //Slider default stuff
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        listaEval.get(posImgObtenida).estrellasTot = progress;
        rellenarImagenes();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
        //Obtener valor y otra vez logica de llenar drawables
    void rellenarImagenes() {
        if (listaEval.get(posImgObtenida).estrellasTot == 0) {
            imgVwEval1.setImageResource(R.drawable.starvacia);
            imgVwEval2.setImageResource(R.drawable.starvacia);
            imgVwEval3.setImageResource(R.drawable.starvacia);
        } else if (listaEval.get(posImgObtenida).estrellasTot == 1) {
            imgVwEval1.setImageResource(R.drawable.starrellna);
            imgVwEval2.setImageResource(R.drawable.starvacia);
            imgVwEval3.setImageResource(R.drawable.starvacia);
        } else if (listaEval.get(posImgObtenida).estrellasTot == 2) {
            imgVwEval1.setImageResource(R.drawable.starrellna);
            imgVwEval2.setImageResource(R.drawable.starrellna);
            imgVwEval3.setImageResource(R.drawable.starvacia);
        } else {
            imgVwEval1.setImageResource(R.drawable.starrellna);
            imgVwEval2.setImageResource(R.drawable.starrellna);
            imgVwEval3.setImageResource(R.drawable.starrellna);
        }
    }

    @Override
    protected void onPause() {
        //Back to Mostrar
        super.onPause();
        startActivity(volverMostrar);
    }
}
