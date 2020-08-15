package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class ControladorOpcion implements EventHandler<ActionEvent> {

    Opcion opcionAsociada;

    public ControladorOpcion(Opcion unaOpcion){
        this.opcionAsociada = unaOpcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("La opcion: " + opcionAsociada.getDescripcion() + "    es correcta: " + opcionAsociada.esCorrecta());
    }
}
