package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Exepciones.NombreVacioError;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.vista.Opciones.VistaOpcion;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorJugar implements EventHandler<ActionEvent> {
    Stage stage;
    TextField nombreJugador;
    TextField nombreJugador2;
    Juego juego;

    public ControladorJugar(Stage stagePrincipal, TextField nombreJugador, TextField nombreJugador2, Juego juego) {
        this.stage = stagePrincipal;
        this.nombreJugador = nombreJugador;
        this.nombreJugador2 = nombreJugador2;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) throws NombreVacioError {

        try{
            if(nombreJugador.getText().trim().isEmpty() || nombreJugador.getText().trim() == null)
                throw new NombreVacioError("El nombre no es correcto");

            Jugador jugador = new Jugador(nombreJugador.getText());
            juego.agregarJugador(jugador);

            jugador = new Jugador(nombreJugador2.getText());
            juego.agregarJugador(jugador);


            juego.crearVistaRonda(stage);

        }catch (NombreVacioError error){

        }
    }
}
