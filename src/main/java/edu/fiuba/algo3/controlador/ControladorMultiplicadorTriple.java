package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.vista.Preguntas.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class ControladorMultiplicadorTriple implements EventHandler<ActionEvent> {

    Jugador jugador;
    VistaPregunta vistaPregunta;
    Button boton;
    boolean activado;


    public ControladorMultiplicadorTriple(Jugador jugador, VistaPregunta vistaPregunta, Button boton){
        this.jugador = jugador;
        this.vistaPregunta = vistaPregunta;
        this.boton = boton;
        activado = false;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if(!activado){
            jugador.activarMultiplicadorTriple(vistaPregunta.getRespuesta());
            activado = true;
            boton.setStyle("-fx-background-color: #ADFF2F;"
                           + "-fx-font-weight: bold;");

            List<String> datos = Arrays.asList(boton.getText().split(" "));
            boton.setText("\ud83d\udd25" + "¡" + datos.get(1).toUpperCase() + " " + datos.get(2).toUpperCase() + " ACTIVADO" + "!" + "\ud83d\udd25");        }
    }
}