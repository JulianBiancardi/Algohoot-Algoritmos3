package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VistaFinJuego extends BorderPane {

    HBox podios = new HBox(20);
    ArrayList <PodioData> podioInfo = new ArrayList<>();

    public VistaFinJuego(ArrayList <Jugador> jugadores){
        this.setStyle("-fx-background-color: #5133a5");
        this.setPadding(new Insets(30,30,30,30));

        AudioClip sonido = new AudioClip(App.class.getResource("/SND_KahootPodium.mp3").toExternalForm());
        sonido.play();

        podioInfo.add(new PodioData(500, new Image("File:src\\resources\\imagenes\\IMG_PrimerPuesto.png")));
        podioInfo.add(new PodioData(200, new Image("File:src\\resources\\imagenes\\IMG_SegundoPuesto.png")));

        crearEncabezado();
        List<Jugador> listaJugadores = ordenarJugadores(jugadores);
        generarPodios(listaJugadores);

        Button botonSalir = new Button("Salir");
        botonSalir.setPrefSize(200,80);
        botonSalir.setOnAction(new ControladorSalir());
        this.setCenter(botonSalir);

        podios.setAlignment(Pos.CENTER);
        this.setBottom(podios);
    }

    private void crearEncabezado() {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);

        Label encabezado = new Label("Podio");
        encabezado.setFont(Font.font("Bonnie Bay", FontWeight.BOLD, FontPosture.ITALIC,70));
        encabezado.setTextFill(Color.WHITE);

        stackPane.getChildren().addAll(encabezado);
        this.setTop(stackPane);
    }

    private List<Jugador> ordenarJugadores(ArrayList<Jugador> jugadores) {
        return jugadores.stream().sorted(Comparator.comparingInt(Jugador::puntos).reversed()).collect(Collectors.toList());
    }

    private void generarPodios(List<Jugador> jugadores) {
        for(int i = 0; i < jugadores.size(); i++){
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
        nombreJugador.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
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
        puntosJugador.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        puntosJugador.setTextFill(Color.WHITE);

        vBox2.getChildren().addAll(puestoImagen,puntosJugador);

        vBoxPrincipal.getChildren().addAll(nombreJugador,vBox2);

        podios.getChildren().add(vBoxPrincipal);
    }

    public class PodioData{
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


