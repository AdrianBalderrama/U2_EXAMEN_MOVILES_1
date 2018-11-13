package com.example.wilson.eva2_examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosRestaurantes {
    int imgRest, estrellasTot;
    String nombreRest, descRest, dirytelRest;

    //Restaurantes por default
    static List<DatosRestaurantes> lista = new ArrayList<>(Arrays.asList(
            new DatosRestaurantes(R.drawable.barrafina, "Barra Fina", "Fino", "Av Juan Escutia", 1),
            new DatosRestaurantes(R.drawable.bourkestreetbakery, "BourkeBakery", "Elegante", "Homero 777", 1),
            new DatosRestaurantes(R.drawable.cafedeadend, "Cafe Deadend", "Mortal", "Calle Industrias 303", 1),
            new DatosRestaurantes(R.drawable.traif, "Traif", "Lujoso", "Cerro de la Cruz 404", 1),
            new DatosRestaurantes(R.drawable.upstate, "UpState", "Nyorkino", "Tecnologico 101", 1),
            new DatosRestaurantes(R.drawable.wafflewolf, "WaffleWolf", "Waffles", "Independencia 123", 1)));
    //Data
    public DatosRestaurantes(int img, String nombre, String desc, String dirytel, int estrellas) {
        imgRest = img;
        nombreRest = nombre;
        descRest = desc;
        dirytelRest = dirytel;
        estrellasTot = estrellas;
    }
}
