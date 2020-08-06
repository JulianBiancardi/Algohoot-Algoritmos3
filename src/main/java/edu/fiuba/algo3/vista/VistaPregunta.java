package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;


public class VistaPregunta extends VBox{
    private final Integer startTime = 20;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    Label contador = new Label(String.valueOf(startTime));

    public VistaPregunta(){

        StackPane stackPane1 = new StackPane();
        mostrarPregunta(stackPane1);

        StackPane stackPane2 = new StackPane();
        mostrarContador(stackPane2);

        GridPane opcionesPregunta = new GridPane();
        mostrarOpciones(opcionesPregunta);
        opcionesPregunta.maxWidthProperty().bind(this.widthProperty());
        opcionesPregunta.setPadding(new Insets(10,10,10,10));

        this.setSpacing(50);
        this.getChildren().addAll(stackPane1,stackPane2,opcionesPregunta);
        this.setAlignment(Pos.TOP_CENTER);
    }

    public void contar(){
        if(secondsPassed > 0){
            secondsPassed--;
            contador.setText(String.valueOf(secondsPassed));
        }
        else tiempo.pause();
    }

    public void mostrarPregunta(StackPane stackPane) {

        ImageView fondoPregunta = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\fondoPregunta.png");
        fondoPregunta.fitWidthProperty().bind(stackPane.widthProperty());
        stackPane.setPrefHeight(150);

        Label enunciadoPregunta = new Label("Enunciado de la pregunta...");
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD,40));
        enunciadoPregunta.setWrapText(true);

        stackPane.getChildren().addAll(fondoPregunta,enunciadoPregunta);
    }

    public void mostrarContador(StackPane stackPane){
        Circle circle = new Circle(50,50,70,Color.valueOf("#844cbe"));
        contador.setTextFill(Color.WHITE);
        contador.setFont(Font.font("Core Mellow", FontWeight.BOLD,55));

        stackPane.getChildren().addAll(circle,contador);

        tiempo = new Timeline(new KeyFrame(Duration.seconds(1),e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();
    }

    public void mostrarOpciones(GridPane opcionesPregunta){

        opcionesPregunta.setMinSize(600,200);
        opcionesPregunta.setMaxSize(1200,200);
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.setHgap(5);
        opcionesPregunta.setVgap(5);

        Button opcion1 = crearBotonOpcion(opcionesPregunta,"Opcion 1");
        opcion1.setStyle("-fx-background-color: #e21b3c");
        Button opcion2 = crearBotonOpcion(opcionesPregunta,"Opcion 2");
        opcion2.setStyle("-fx-background-color: #1368ce");
        Button opcion3 = crearBotonOpcion(opcionesPregunta,"Opcion 3");
        opcion3.setStyle("-fx-background-color: #d89e00");
        Button opcion4 = crearBotonOpcion(opcionesPregunta,"Opcion 4");
        opcion4.setStyle("-fx-background-color: #26890c");


        opcionesPregunta.addRow(0,opcion1,opcion2);
        opcionesPregunta.addRow(1,opcion3,opcion4);
    }

    private Button crearBotonOpcion(Pane root,String descripcion){
        Button boton = new Button();
        Label texto = new Label(descripcion);

        texto.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        texto.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        texto.setTextFill(Color.WHITE);

        boton.setGraphic(texto);
        boton.prefWidthProperty().bind(root.widthProperty());
        boton.prefHeightProperty().bind(root.heightProperty());
        boton.setOnAction(e -> System.out.println("Me tocaron"));

        return boton;
    }

}
