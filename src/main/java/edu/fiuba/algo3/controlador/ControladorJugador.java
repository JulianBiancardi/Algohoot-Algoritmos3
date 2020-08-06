package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.vista.VistaJugador;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorJugador implements EventHandler {
    VistaJugador vista;
    Jugador jugador;

    public ControladorJugador(VistaJugador vista, Jugador unaJugador){
        this.vista = vista;
        this.jugador = unaJugador;

        jugador.agregarObservador(vista);
    }

    @Override
    public void handle(Event event) {
        jugador.modificarPuntos(1);
    }
}
