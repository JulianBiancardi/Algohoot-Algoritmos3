package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJugador;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaJugador implements Observador{
    Jugador jugador;
    Label nombreJugador;
    Label puntosJugador;
    VBox layoutPrincipal = new VBox();
    Scene sceneJugador = new Scene(layoutPrincipal);

    public VistaJugador(Jugador unJugador){
        jugador = unJugador;
        nombreJugador = new Label("Nombre");
        puntosJugador = new Label("Puntos");
        Button botonSumarPuntos = new Button("SUMAR PUNTOS");
        botonSumarPuntos.setOnAction(new ControladorJugador(this,jugador));

        layoutPrincipal.getChildren().add(nombreJugador);
        layoutPrincipal.getChildren().add(puntosJugador);
        layoutPrincipal.getChildren().add(botonSumarPuntos);

        layoutPrincipal.setAlignment(Pos.TOP_CENTER);
        layoutPrincipal.setSpacing(5);
    }

    public Scene getScene(){
        return sceneJugador;
    }

    @Override
    public void actualizar() {
        nombreJugador.setText(jugador.nombre());
        puntosJugador.setText(String.valueOf(jugador.puntos()));
    }
}
