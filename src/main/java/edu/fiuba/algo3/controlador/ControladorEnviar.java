package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


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
