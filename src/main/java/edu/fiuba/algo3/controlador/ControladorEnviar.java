package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.FabricaVistaPreguntas;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviar implements EventHandler<ActionEvent> {
    Stage stage;
    Juego juego;
    ArrayList<Opcion> opcionesElegidas;

    public ControladorEnviar(Stage stagePrincipal, Juego juego, ArrayList<Opcion> opcionesElegidas){
        this.stage = stagePrincipal;
        this.juego = juego;
        this.opcionesElegidas = opcionesElegidas;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        System.out.println("Enviando respuesta");
        opcionesElegidas.forEach(opcion -> System.out.println(opcion.getDescripcion()));

        //Creo la respuesta del jugador
        Jugador jugador = juego.turnoDe();
        Respuesta respuesta = new Respuesta(jugador, juego.obtenerRondaActual().obtenerPregunta());
        opcionesElegidas.forEach(opcion -> respuesta.agregarOpcion(opcion));
        //Le envio la respuesta
        juego.obtenerRondaActual().agregarRespuesta(respuesta);

        juego.siguienteTurno();

        if(juego.terminoRonda()){
            juego.evaluarRespuestas();
            if(juego.hayRondaSiguiente()) {
                juego.siguienteRonda();
                VistaPrincipal vistaPregunta = new VistaPrincipal(juego);
                FabricaVistaPreguntas.crearVista(juego.obtenerRondaActual().obtenerPregunta(), vistaPregunta, stage);
                Scene nuevaPregunta = new Scene(vistaPregunta);
                stage.setScene(nuevaPregunta);
            }
            else{
                VistaPuntos vistaPuntos = new VistaPuntos(juego.obtenerJugadores());
                stage.setScene(new Scene (vistaPuntos));
            }
        }
        else{
            VistaPrincipal vistaPregunta = new VistaPrincipal(juego);
            FabricaVistaPreguntas.crearVista(juego.obtenerRondaActual().obtenerPregunta(), vistaPregunta, stage);
            Scene nuevaPregunta = new Scene(vistaPregunta);
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
