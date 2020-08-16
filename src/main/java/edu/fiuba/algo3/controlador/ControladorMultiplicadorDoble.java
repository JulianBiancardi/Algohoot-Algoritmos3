package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMultiplicadorDoble implements EventHandler<ActionEvent> {

    Jugador jugador;
    boolean activado;
    Respuesta respuesta;

    public ControladorMultiplicadorDoble (Jugador jugador, Respuesta respuesta){
        this.jugador = jugador;
        activado = false;
        this.respuesta = respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!activado) {
            jugador.activarMultiplicadorDoble(respuesta);
            activado = true;
        }
    }
}
