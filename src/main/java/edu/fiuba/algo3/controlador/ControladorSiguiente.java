package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.FabricaVistaPreguntas;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControladorSiguiente implements EventHandler<ActionEvent> {
    Stage stage;
    Juego juego;

    public ControladorSiguiente (Stage stage, Juego juego){
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if(juego.hayRondaSiguiente()) {
            juego.siguienteRonda();
            VistaPrincipal vistaPregunta = new VistaPrincipal(juego);
            FabricaVistaPreguntas.crearVista(juego.obtenerRondaActual().obtenerPregunta(), vistaPregunta, stage);
            Scene nuevaPregunta = new Scene(vistaPregunta);
            stage.setScene(nuevaPregunta);
        }
    }
}
