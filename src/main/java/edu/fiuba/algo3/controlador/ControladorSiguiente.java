package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.VistaFinJuego;
import edu.fiuba.algo3.vista.VistaIntroPregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ControladorSiguiente implements EventHandler<ActionEvent> {
    Stage stage;
    Juego juego;
    private final AudioClip sonido;

    public ControladorSiguiente(Stage stage, Juego juego, AudioClip sonido){
        this.stage = stage;
        this.juego = juego;
        this.sonido = sonido;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        sonido.stop();

        if(juego.hayRondaSiguiente()) {
            juego.siguienteRonda();
            VistaIntroPregunta vistaIntroPregunta = new VistaIntroPregunta(stage,juego);
            stage.getScene().setRoot(vistaIntroPregunta);
        }
        else{
            VistaFinJuego vistaFinJuego = new VistaFinJuego(juego.obtenerJugadores());
            stage.getScene().setRoot(vistaFinJuego);
        }
        stage.setFullScreen(true);
    }
}
