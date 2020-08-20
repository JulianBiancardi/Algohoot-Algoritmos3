package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorSiguiente;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VistaPuntos extends BorderPane {
    private AudioClip sonido = new AudioClip("File:src/resources/sonidos/SND_KahootPoints.mp3");
    private VBox puestosJugadores = new VBox(10);
    private int puesto = 1;

    public VistaPuntos(Juego juego, Stage stage){
        this.setStyle("-fx-background-color: #5133a5");
        sonido.play();

        inicializarTitulo();
        inicializarBotonSiguiente(stage,juego);
        ArrayList <Jugador> jugadores = juego.obtenerJugadores();

        jugadores.stream()
                .sorted(Comparator.comparingInt(Jugador::puntos)
                        .reversed()) // Ordeno para mostrar los de mayor puntaje primero!
                .collect(Collectors.toList())
                .forEach(this::mostrarJugador);

        puestosJugadores.setAlignment(Pos.TOP_CENTER);
        puestosJugadores.setMaxSize(1200,600);
        this.setCenter(puestosJugadores);
    }

    private void inicializarTitulo(){
        Label enunciadoPregunta = new Label("Puestos");
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD,80));
        enunciadoPregunta.setAlignment(Pos.CENTER);
        enunciadoPregunta.setStyle("-fx-background-color: white");
        enunciadoPregunta.prefWidthProperty().bind(this.widthProperty());

        this.setTop(enunciadoPregunta);
    }

    private void inicializarBotonSiguiente(Stage stage, Juego juego){
        Button botonSiguiente = new Button("Siguiente");
        botonSiguiente.setStyle("-fx-background-radius: 5px;"
                + "-fx-background-color: #D5D5D5;"
                + "-fx-text-fill: black;"
                + "-fx-font-size: 30;"
                + "-fx-font-weight: bold;"
                );
        botonSiguiente.setOnAction(new ControladorSiguiente(stage,juego, sonido));
        botonSiguiente.setPrefSize(250,80);
        Pane pane = new Pane(botonSiguiente);
        pane.setPadding(new Insets(10,10,10,10));

        this.setRight(pane);
    }

    private void mostrarJugador(Jugador unJugador){

        Label nombreJugador = new Label(puesto + "   " + unJugador.nombre());
        nombreJugador.setFont(Font.font("Montserrat", FontWeight.BOLD,40));
        nombreJugador.setTextFill(Color.WHITE);

        Label puntosJugador = new Label(String.valueOf(unJugador.puntos()));
        puntosJugador.setFont(Font.font("Montserrat", FontWeight.BOLD,40));
        puntosJugador.setTextFill(Color.WHITE);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(nombreJugador,puntosJugador);
        anchorPane.setStyle("-fx-background-color: #25076b");

        AnchorPane.setTopAnchor(nombreJugador,20.0);
        AnchorPane.setLeftAnchor(nombreJugador,20.0);
        AnchorPane.setBottomAnchor(nombreJugador,20.0);

        AnchorPane.setTopAnchor(puntosJugador,20.0);
        AnchorPane.setRightAnchor(puntosJugador,20.0);
        AnchorPane.setBottomAnchor(puntosJugador,20.0);

        puestosJugadores.getChildren().add(anchorPane);
        puesto++;
    }
}

