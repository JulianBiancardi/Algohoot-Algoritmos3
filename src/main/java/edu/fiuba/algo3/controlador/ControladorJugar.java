package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class ControladorJugar implements EventHandler<ActionEvent> {
    private final List<TextField> nombresJugadores;
    private final Stage stage;
    private final Juego juego;
    private final Label notificacionMensaje;

    public ControladorJugar(Stage stagePrincipal, List<TextField> nombresJugadores, Juego juego, Label notificacionMensaje){
        this.stage = stagePrincipal;
        this.nombresJugadores = nombresJugadores;
        this.juego = juego;
        this.notificacionMensaje = notificacionMensaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) throws NombreVacioError{
        try {
            if(nombresJugadores.get(0).getText().trim().isEmpty() || nombresJugadores.get(1).getText().trim().isEmpty())
                throw new NombreVacioError("El nombre no es correcto");

            Jugador jugador = new Jugador(nombresJugadores.get(0).getText());
            juego.agregarJugador(jugador);

            jugador = new Jugador(nombresJugadores.get(1).getText());
            juego.agregarJugador(jugador);

            // VistaIntroPregunta vistaIntroPregunta = new VistaIntroPregunta(stage,juego);
            VistaPrincipal vistaPrincipal = new VistaPrincipal(stage, juego, juego.obtenerRondaActual().obtenerPregunta());
            stage.setScene(new Scene(vistaPrincipal));
            stage.setFullScreen(true);
        } catch (NombreVacioError error) {
            this.notificacionMensaje.setText("¡Deben ingresar un nombre para comenzar a jugar!");
        }
    }
}