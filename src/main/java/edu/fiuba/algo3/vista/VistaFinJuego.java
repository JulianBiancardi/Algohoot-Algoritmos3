package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VistaFinJuego extends BorderPane {

    HBox podios = new HBox(20);
    ArrayList<PodioData> podioInfo = new ArrayList<>();

    public VistaFinJuego(ArrayList<Jugador> jugadores){
        this.setStyle("-fx-background-color: #5133a5");
        this.setPadding(new Insets(30, 30, 30, 30));

        podioInfo.add(new PodioData(500, new Image(ConstantesAlgohoot.ICON_PRIMER_PUESTO)));
        podioInfo.add(new PodioData(200, new Image(ConstantesAlgohoot.ICON_SEGUNDO_PUESTO)));

        crearEncabezado();
        ordenarJugadores(jugadores);
        generarPodios(jugadores);

        Button botonSalir = new Button("     Salir     ");
        botonSalir.setStyle("-fx-background-radius: 0px;"
                            + "-fx-background-color: #25076b;"
                            + "-fx-text-fill: #ffffff;"
                            + "-fx-font-size: 16;"
                            + "-fx-padding: 5px;");
        botonSalir.setOnAction(new ControladorSalir());
        HBox hbox = new HBox(botonSalir);
        hbox.setPadding(new Insets(10, 10, 15, 10));
        hbox.setAlignment(Pos.CENTER);
        this.setCenter(hbox);

        podios.setAlignment(Pos.CENTER);
        this.setBottom(podios);
        this.setPrefSize(ConstantesAlgohoot.MIN_WIDTH, ConstantesAlgohoot.MIN_HEIGHT);
    }

    private void crearEncabezado(){
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);

        Label encabezado = new Label("Podio");
        encabezado.setFont(Font.font("Bonnie Bay", FontWeight.BOLD, FontPosture.ITALIC, 70));
        encabezado.setTextFill(Color.WHITE);

        stackPane.getChildren().addAll(encabezado);
        this.setTop(stackPane);
    }

    private void ordenarJugadores(ArrayList<Jugador> jugadores){
        jugadores.stream()
                .sorted(Comparator.comparingInt(Jugador::puntos)
                        .reversed()) // Ordeno para mostrar los de mayor puntaje primero!
                .collect(Collectors.toList());
    }

    private void generarPodios(ArrayList<Jugador> jugadores){
        for (int i = 0; i < jugadores.size(); i++) {
            PodioData podioDataActal = podioInfo.get(i);
            crearPodio(jugadores.get(i), podioDataActal);
        }
    }


    private void crearPodio(Jugador jugador, PodioData podioData){
        VBox vBoxPrincipal = new VBox();
        vBoxPrincipal.setAlignment(Pos.BOTTOM_CENTER);
        vBoxPrincipal.setSpacing(20);
        vBoxPrincipal.setPrefHeight(podioData.getTamanio());
        vBoxPrincipal.setPrefWidth(300);

        Label nombreJugador = new Label(jugador.nombre());
        nombreJugador.setAlignment(Pos.CENTER);
        nombreJugador.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        nombreJugador.setTextFill(Color.WHITE);
        nombreJugador.setStyle("-fx-background-color: #25076b");
        nombreJugador.prefWidthProperty().bind(vBoxPrincipal.widthProperty());
        nombreJugador.setMinHeight(50);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.prefHeightProperty().bind(vBoxPrincipal.heightProperty());
        vBox2.setSpacing(5);
        vBox2.setStyle("-fx-background-color: #864cbf");

        ImageView puestoImagen = new ImageView(podioData.getIcono());

        Label puntosJugador = new Label(String.valueOf(jugador.puntos()) + " puntos");
        puntosJugador.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        puntosJugador.setTextFill(Color.WHITE);

        vBox2.getChildren().addAll(puestoImagen, puntosJugador);

        vBoxPrincipal.getChildren().addAll(nombreJugador, vBox2);

        podios.getChildren().add(vBoxPrincipal);
    }

    public class PodioData {
        int tamanio;
        Image icono;

        public PodioData(int tamanio, Image icono){
            this.tamanio = tamanio;
            this.icono = icono;
        }

        public int getTamanio(){
            return tamanio;
        }

        public Image getIcono(){
            return icono;
        }
    }
}


