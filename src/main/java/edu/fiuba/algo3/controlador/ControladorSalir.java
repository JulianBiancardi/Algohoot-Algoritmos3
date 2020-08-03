package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorSalir implements EventHandler<ActionEvent> {
    Stage stage;
    public ControladorSalir(Stage stagePrincipal) {
        stage = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}
