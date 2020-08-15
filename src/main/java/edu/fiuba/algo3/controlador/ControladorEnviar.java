package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public void handle(ActionEvent actionEvent) {
        System.out.println("Enviando respuesta");
        opcionesElegidas.forEach(opcion -> System.out.println(opcion.getDescripcion()));

        juego.siguienteTurno(stage);
    }
}
