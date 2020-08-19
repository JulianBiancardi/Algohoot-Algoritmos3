package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;

public class VistaEnunciado {

    public static Label obtenerLabelResponsive(Opcion unaOpcion){
        String enunciado = unaOpcion.getDescripcion();
        Label enunciadoPregunta = new Label();
        enunciadoPregunta.setText(enunciado);
        enunciadoPregunta.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        if(enunciado.length() >= 12){
            String enunciadoDivididoEnDos = obtenerStringResponsive(enunciado);
            enunciadoPregunta.setText(enunciadoDivididoEnDos);
            enunciadoPregunta.setFont(Font.font("Montserrat", FontWeight.BOLD, 14));
        }

        return enunciadoPregunta;
    }

    public static String obtenerStringResponsive(String enunciado){
        List<String> datos = Arrays.asList(enunciado.split(" "));

        String arriba = "";
        String abajo = "";

        for (int i = 0; i < datos.size() / 2; i++)
            arriba = arriba + " " + datos.get(i);

        for (int i = datos.size() / 2; i < datos.size(); i++)
            abajo = abajo + " " + datos.get(i);

        return (arriba + "\n" + abajo + "\n");
    }
}
