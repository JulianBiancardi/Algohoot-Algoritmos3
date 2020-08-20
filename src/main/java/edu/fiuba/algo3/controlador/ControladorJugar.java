package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;
import edu.fiuba.algo3.vista.VistaFinJuego;
import edu.fiuba.algo3.vista.VistaIntroPregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorJugar implements EventHandler<ActionEvent> {
    Stage stage;
    TextField nombreJugador;
    TextField nombreJugador2;
    Juego juego;
    private Label notificacionMensaje;

    public ControladorJugar(Stage stagePrincipal, TextField nombreJugador, TextField nombreJugador2, Juego juego, Label notificacionMensaje) {
        this.stage = stagePrincipal;
        this.nombreJugador = nombreJugador;
        this.nombreJugador2 = nombreJugador2;
        this.juego = juego;
        this.notificacionMensaje = notificacionMensaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) throws NombreVacioError{

        try{
            if(nombreJugador.getText().trim().isEmpty() || nombreJugador2.getText().trim().isEmpty())
                throw new NombreVacioError("El nombre no es correcto");

            Jugador jugador = new Jugador(nombreJugador.getText());
            juego.agregarJugador(jugador);

            jugador = new Jugador(nombreJugador2.getText());
            juego.agregarJugador(jugador);

            VistaIntroPregunta vistaIntroPregunta = new VistaIntroPregunta(stage,juego);
            stage.setScene(new Scene(vistaIntroPregunta));
            stage.setFullScreen(true);

        }catch (NombreVacioError error){
            this.notificacionMensaje.setText("¡Deben ingresar un nombre para comenzar a jugar!");
        }
    }
}
