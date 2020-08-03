package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorJugar implements EventHandler<ActionEvent> {
    Stage stage;
    public ControladorJugar(Stage stagePrincipal) {
        stage = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaPregunta vistaPregunta = new VistaPregunta();
        Scene scenePregunta = new Scene(vistaPregunta);
        stage.setScene(scenePregunta);
    }
}
