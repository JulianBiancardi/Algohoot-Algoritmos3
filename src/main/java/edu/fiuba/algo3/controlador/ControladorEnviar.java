package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.vista.Preguntas.VistaPregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControladorEnviar implements EventHandler<ActionEvent> {
    Stage stage;
    Juego juego;
    Timeline tiempo;
    VistaPregunta vistaPregunta;

    public ControladorEnviar(Stage stagePrincipal, Juego juego, Timeline tiempo, VistaPregunta vistaPregunta){
        this.stage = stagePrincipal;
        this.juego = juego;
        this.vistaPregunta = vistaPregunta;
        this.tiempo = tiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        tiempo.pause();

        Jugador jugador = juego.turnoDe();
        juego.obtenerRondaActual().agregarRespuesta(vistaPregunta.obtenerRespuesta(jugador));

        juego.siguienteTurno();

        if(juego.terminoRonda()){
            juego.evaluarRespuestas();
            VistaPuntos vistaPuntos = new VistaPuntos(juego,stage);
            stage.setScene(new Scene (vistaPuntos));
        }
        else{
            VistaPrincipal vistaPrincipal = new VistaPrincipal(stage,juego,juego.obtenerRondaActual().obtenerPregunta());
            Scene nuevaPregunta = new Scene(vistaPrincipal);
            stage.setScene(nuevaPregunta);
        }

    }
}


/*
*Agregar multiplicadores y exclusividad a la vista, con sus controladores
*Agregar vistas ordered y groupe choice
*Solucionar problema al agregar respuestas grupales en el controlador enviar (este)
*
 */
