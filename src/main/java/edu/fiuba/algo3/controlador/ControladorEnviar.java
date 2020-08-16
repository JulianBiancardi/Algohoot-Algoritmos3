package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.vista.VistaPrincipal;
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
        //Actualizar el juego
        //Crear una nueva vista con este juego actualizado.

        juego.siguienteTurno();

        if(juego.hayRondaSiguiente()){
            if(juego.terminoRonda())
                juego.siguienteRonda();

            VistaPrincipal vistaPregunta = new VistaPrincipal(juego);
            vistaPregunta.crearVista(stage, juego.obtenerRondaActual().obtenerPregunta());

            Scene nuevaPregunta = new Scene(vistaPregunta);
            stage.setScene(nuevaPregunta);
        } else
            System.exit(0);
    }
}
