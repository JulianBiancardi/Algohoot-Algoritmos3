package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviar implements EventHandler<ActionEvent> {
    Stage stage;

    public ControladorEnviar(Stage stagePrincipal){
        this.stage = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Enviando respuesta");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Joaco"));
        jugadores.add(new Jugador("Leo"));
        jugadores.add(new Jugador("Fede"));
        jugadores.add(new Jugador("Tomas"));

        Scene scenePuntos = new Scene(new VistaPuntos(jugadores),600,600);
        stage.setScene(scenePuntos);
    }
}
