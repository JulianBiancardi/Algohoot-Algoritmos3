package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.vista.Opciones.VistaPregunta;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class VistaPrincipal extends BorderPane{
    private StackPane stackPane1 = new StackPane();
    private HBox hBox = new HBox();
    private VistaPregunta vistaOpciones;

    private final Integer startTime = 20;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    Label contador = new Label(String.valueOf(startTime));

    private Juego juego;

    public VistaPrincipal(Juego juego){
        this.juego = juego;
    }


    public void contar(){
        if(secondsPassed > 0){
            secondsPassed--;
            contador.setText(String.valueOf(secondsPassed));
        }
        else {
            tiempo.pause();
            vistaOpciones.responder();
        }
    }

    public void crearVistaVoF(Stage stage, VoF pregunta){
        mostrarPregunta(stackPane1,pregunta.getEnunciado());
        mostrarContador(hBox);

        vistaOpciones = new VistaVoF(stage,pregunta,juego);
        vistaOpciones.getLayout().maxWidthProperty().bind(this.widthProperty());
        vistaOpciones.getLayout().setPadding(new Insets(10,10,10,10));

        this.setBottom(vistaOpciones.getLayout());
    }

    public void crearVistaMultipleChoice(Stage stage, MultipleChoice pregunta) {
        mostrarPregunta(stackPane1,pregunta.getEnunciado());
        mostrarContador(hBox);

        vistaOpciones = new VistaMultipleChoice(stage,pregunta,juego);
        vistaOpciones.getLayout().maxWidthProperty().bind(this.widthProperty());
        vistaOpciones.getLayout().setPadding(new Insets(10,10,10,10));

        this.setBottom(vistaOpciones.getLayout());
    }

    private void mostrarPregunta(StackPane stackPane,String enunciado) {
        ImageView fondoPregunta = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\fondoPregunta.png");
        fondoPregunta.fitWidthProperty().bind(stackPane.widthProperty());
        stackPane.setPrefHeight(150);

        Label enunciadoPregunta = new Label(enunciado);
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD,55));
        enunciadoPregunta.setWrapText(true);

        stackPane.getChildren().addAll(fondoPregunta,enunciadoPregunta);
        this.setTop(stackPane);
    }

    private void mostrarContador(HBox hBox){
        StackPane stackPane = new StackPane();
        Circle circle = new Circle(100,Color.valueOf("#844cbe"));
        contador.setTextFill(Color.WHITE);
        contador.setFont(Font.font("Core Mellow", FontWeight.BOLD,80));
        stackPane.getChildren().addAll(circle,contador);

        tiempo = new Timeline(new KeyFrame(Duration.seconds(1),e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();

        Label nombreJugador1 = new Label(juego.turnoDe().nombre());
        nombreJugador1.setFont(Font.font("Core Mellow", FontWeight.BOLD,30));

        Label nombreJugador2 = new Label(juego.turnoDe().nombre());
        nombreJugador2.setText("Prueba");
        nombreJugador2.setTextFill(Color.GRAY);
        nombreJugador2.setFont(Font.font("Core Mellow", FontWeight.BOLD,30));


        hBox.getChildren().addAll(nombreJugador1,stackPane,nombreJugador2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);
        hBox.maxWidthProperty().bind(this.widthProperty());
        this.setCenter(hBox);
    }
}