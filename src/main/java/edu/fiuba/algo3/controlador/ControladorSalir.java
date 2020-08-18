package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorSalir implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        System.exit(0);
    }
}
