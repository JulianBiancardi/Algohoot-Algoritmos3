package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorSiguiente;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VistaPuntos extends VBox {
    private int puesto = 1;

    public VistaPuntos(Juego juego, Stage stage){
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#864cbf"), null, Insets.EMPTY)));
        this.setSpacing(10);
        this.setPrefSize(600, 600);

        inicializarTitulo();
        inicializarBotonSiguiente(stage, juego);
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();

        jugadores.stream()
                .sorted(Comparator.comparingInt(Jugador::puntos)
                        .reversed()) // Ordeno para mostrar los de mayor puntaje primero!
                .collect(Collectors.toList())
                .forEach(this::mostrarJugador);
    }

    private void inicializarTitulo(){
        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(100);
        stackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, Insets.EMPTY)));

        Label enunciadoPregunta = new Label("Puestos");
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD, 40));

        stackPane.getChildren().add(enunciadoPregunta);
        this.getChildren().add(stackPane);
    }

    private void inicializarBotonSiguiente(Stage stage, Juego juego){
        Label label = new Label("Siguiente");
        label.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        label.setTextFill(Color.BLACK);

        Button botonSiguiente = new Button();
        botonSiguiente.setOnAction(new ControladorSiguiente(stage, juego));
        botonSiguiente.setPrefSize(150, 50);
        botonSiguiente.setGraphic(label);
        botonSiguiente.setBackground(new Background(new BackgroundFill(Color.valueOf("#D5D5D5"), null, Insets.EMPTY)));

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(botonSiguiente);
        AnchorPane.setRightAnchor(botonSiguiente, 10.0);

        this.getChildren().add(anchorPane);
    }

    private void mostrarJugador(Jugador unJugador){

        Label nombreJugador = new Label(String.valueOf(puesto) + "  " + unJugador.nombre());
        nombreJugador.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        nombreJugador.setTextFill(Color.WHITE);

        Label puntosJugador = new Label(String.valueOf(unJugador.puntos()));
        puntosJugador.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        puntosJugador.setTextFill(Color.WHITE);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPadding(new Insets(0, 50, 0, 50));
        anchorPane.getChildren().addAll(nombreJugador, puntosJugador);
        AnchorPane.setLeftAnchor(nombreJugador, 10.0);
        AnchorPane.setRightAnchor(puntosJugador, 10.0);

        this.getChildren().add(anchorPane);
        puesto++;
    }
}

