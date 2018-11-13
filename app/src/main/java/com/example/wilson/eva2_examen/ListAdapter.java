package com.example.wilson.eva2_examen;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<DatosRestaurantes> {
    Context contexto;
    int iLayout;
    List<DatosRestaurantes> datosRest;


    public ListAdapter(@NonNull Context context, int resource, @NonNull List<DatosRestaurantes> objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        datosRest = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ImageView imgVwLista, imgVwStar1, imgVwStar2, imgVwStar3;
        TextView txtVwNombreLista, txtVwDescLista, txtVwDirTelLista;
        View vwFila = convertView;
        //Inflador (xml to sth usable)
        if (vwFila == null){
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vwFila = CrearLayout.inflate(iLayout, parent, false);
        }
        imgVwLista = vwFila.findViewById(R.id.imgVwLista);
        txtVwNombreLista = vwFila.findViewById(R.id.txtVwNombreLista);
        txtVwDescLista = vwFila.findViewById(R.id.txtVwDescLista);
        txtVwDirTelLista = vwFila.findViewById(R.id.txtVwDirTelLista);
        imgVwStar1 = vwFila.findViewById(R.id.imgVwStar1);
        imgVwStar2 = vwFila.findViewById(R.id.imgVwStar2);
        imgVwStar3 = vwFila.findViewById(R.id.imgVwStar3);

        imgVwLista.setImageResource(datosRest.get(position).imgRest);
        txtVwNombreLista.setText(datosRest.get(position).nombreRest);
        txtVwDescLista.setText(datosRest.get(position).descRest);
        txtVwDirTelLista.setText(datosRest.get(position).dirytelRest);
        //Estrellas logica set
        if (datosRest.get(position).estrellasTot == 0) {
            imgVwStar1.setImageResource(R.drawable.starvacia);
            imgVwStar2.setImageResource(R.drawable.starvacia);
            imgVwStar3.setImageResource(R.drawable.starvacia);
        } else if (datosRest.get(position).estrellasTot == 1) {
            imgVwStar1.setImageResource(R.drawable.starrellna);
            imgVwStar2.setImageResource(R.drawable.starvacia);
            imgVwStar3.setImageResource(R.drawable.starvacia);
        } else if (datosRest.get(position).estrellasTot == 2) {
            imgVwStar1.setImageResource(R.drawable.starrellna);
            imgVwStar2.setImageResource(R.drawable.starrellna);
            imgVwStar3.setImageResource(R.drawable.starvacia);
        } else {
            imgVwStar1.setImageResource(R.drawable.starrellna);
            imgVwStar2.setImageResource(R.drawable.starrellna);
            imgVwStar3.setImageResource(R.drawable.starrellna);

        }
        return vwFila;
    }
}
