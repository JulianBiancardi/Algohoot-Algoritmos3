package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviar implements EventHandler<ActionEvent> {
    Stage stage;
    Juego juego;
    public ControladorEnviar(Stage stagePrincipal, Juego juego){
        this.stage = stagePrincipal;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Enviando respuesta");
        juego.siguienteTurno(stage);

    }
}
