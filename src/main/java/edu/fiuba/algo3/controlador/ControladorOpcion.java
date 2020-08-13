package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
