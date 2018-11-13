package com.example.wilson.eva2_examen;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

public class AdaptadorImagenes extends ArrayAdapter<DatosRestaurantes>{
    int iLayout;
    private Context contexto;
    List<DatosRestaurantes> datosRest;

    public AdaptadorImagenes(@NonNull Context context, int resource, @NonNull List<DatosRestaurantes> objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        datosRest = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ImageView imgVwSelec;
        View vFila = view;

        if (vFila == null){
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vFila = CrearLayout.inflate(iLayout, parent, false);
        }

        imgVwSelec = vFila.findViewById(R.id.imgVwSelec);
        imgVwSelec.setImageResource(datosRest.get(position).imgRest);

        return vFila;
    }
}
