package com.example.francisco.mallsbeaconslocation.data;

import com.example.francisco.mallsbeaconslocation.models.Recomendation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhovy on 25/09/2017.
 */

public class Data {

    private static List<Recomendation> recomendaciones;
    public static List<Recomendation> getRecomendaciones(){
        if (recomendaciones == null){

            recomendaciones = new ArrayList<>();
            Recomendation recomendation1 = new Recomendation();
            recomendation1.setItemname("Arroz doña pepa");
            recomendation1.setItemdescription("Arroz de los cultivos de doña pepa, lugar donde trabajan los minions criollos");
            recomendation1.setItemurl("http://www.curiosfera.com/wp-content/uploads/2016/08/Qu%C3%A9-es-el-arroz.jpg");
            recomendation1.setItemsodium("50mg");
            recomendation1.setItemsugar("25g");

            Recomendation recomendation2 = new Recomendation();
            recomendation2.setItemname("dulces wonka");
            recomendation2.setItemdescription("aprobados por los umpalumpas");
            recomendation2.setItemurl("https://i.pinimg.com/originals/05/31/3f/05313fa859c8baa006852d2d2ff70f3f.jpg");
            recomendation2.setItemsodium("70mg");
            recomendation2.setItemsugar("40g");

            Recomendation recomendation3 = new Recomendation();
            recomendation3.setItemname("agua del mar muerto");
            recomendation3.setItemdescription("agua de los guerreros se bañaban en sus aguas despues de la batalla");
            recomendation3.setItemurl("http://s1.1zoom.me/b5050/302/Boats_Water_Vikings_499620_3840x2400.jpg");
            recomendation3.setItemsodium("40mg");
            recomendation3.setItemsugar("5g");

            recomendaciones.add(recomendation1);
            recomendaciones.add(recomendation2);
            recomendaciones.add(recomendation3);
        }

        return recomendaciones;
    }
}
