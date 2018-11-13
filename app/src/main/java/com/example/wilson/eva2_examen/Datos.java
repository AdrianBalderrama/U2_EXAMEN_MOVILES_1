package com.example.wilson.eva2_examen;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
//ALL DATA get
public class Datos extends AppCompatActivity {
    ImageView imgVwAgregar;
    Intent recibirIntent;
    final static int LISTA_REST = 1000;
    EditText edtTxtNombre, edtTxtDesc, edtTxtDirTel;
    List<DatosRestaurantes> listaAgregar = DatosRestaurantes.lista;

    int imagenId = R.drawable.barrafina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        imgVwAgregar = findViewById(R.id.imgVwAgregar);
        edtTxtNombre = findViewById(R.id.edtTxtNombre);
        edtTxtDesc = findViewById(R.id.edtTxtDesc);
        edtTxtDirTel = findViewById(R.id.edtTxtDirTel);

        recibirIntent = new Intent(this, ListaImagenes.class);
        //Lista imagenes a elegir click listener
        imgVwAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(recibirIntent, LISTA_REST);
            }
        });
    }
        //Agregar datos
    public void onClickGuardar(View view) {
        String nombre, desc, dirTel;
        //Guardado, si es vacio default else get (op ternario).
        nombre = TextUtils.isEmpty(edtTxtNombre.getText().toString()) ? "uknown" :
                edtTxtNombre.getText().toString();

        desc = TextUtils.isEmpty(edtTxtDesc.getText().toString())  ? "uknown" :
                edtTxtDesc.getText().toString();

        dirTel = TextUtils.isEmpty(edtTxtDirTel.getText().toString()) ? "uknown" :
                edtTxtDirTel.getText().toString();

        listaAgregar.add(new DatosRestaurantes(imagenId, nombre, desc, dirTel, 0));
        Toast.makeText(this, "Agregado a la Lista", Toast.LENGTH_LONG).show();
        finish();
    }

    //Activity result for the select of images
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            // Check which request we're responding to
        if (requestCode==LISTA_REST){
            // Make sure the request was successful
            if (resultCode== Activity.RESULT_OK){
                // The user picked an Image
                // Is replaced both in the image shown in Datos and the data sent

                imgVwAgregar.setImageResource(data.getIntExtra("IMGSELEC", R.drawable.barrafina));
                imagenId = data.getIntExtra("IMGSELEC", R.drawable.barrafina);

            }
        }
    }
}
