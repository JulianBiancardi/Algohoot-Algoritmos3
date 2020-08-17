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

public class ControladorExclusividad implements EventHandler<ActionEvent> {

    Jugador jugador;
    VistaPregunta vistaPregunta;
    Button boton;
    boolean activado;


    public ControladorExclusividad (Jugador jugador, VistaPregunta vistaPregunta, Button boton){
        this.jugador = jugador;
        this.vistaPregunta = vistaPregunta;
        this.boton = boton;
        activado = false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!activado) {
            jugador.activarExclusividad(vistaPregunta.getRespuesta());
            activado = true;
            boton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ADFF2F"),null, Insets.EMPTY)));
        }
    }

}
