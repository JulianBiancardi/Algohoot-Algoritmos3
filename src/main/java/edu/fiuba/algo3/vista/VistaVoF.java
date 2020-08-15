package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviar;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Opciones.VistaPregunta;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class VistaVoF extends VBox implements VistaPregunta {

    Button botonEnviar = new Button();
    GridPane opcionesPregunta = new GridPane();
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();

    ArrayList<Opcion> opcionesElegidas = new ArrayList<>();

    public VistaVoF(Stage stage, VoF pregunta, Juego juego, Timeline tiempo){
        opcionesInfo.put(0,new VistaOpcionData(0,0, Color.valueOf("#e21b3c")));
        opcionesInfo.put(1,new VistaOpcionData(0,1, Color.valueOf("#1368ce")));

        inicializarBotonEnviar(stage,juego,tiempo);
        inicializarOpciones(pregunta);

        this.getChildren().addAll(botonEnviar,opcionesPregunta);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        opcionesPregunta.maxWidthProperty().bind(this.widthProperty());
    }

    public void inicializarBotonEnviar(Stage stage, Juego juego, Timeline tiempo){
        botonEnviar.setPrefSize(150,80);
        botonEnviar.setStyle("-fx-background-color: #26890c");

        Label label = new Label("Enviar");
        label.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        label.setTextFill(Color.WHITE);
        botonEnviar.setGraphic(label);

        ControladorEnviar enviarRespuesta = new ControladorEnviar(stage,juego,opcionesElegidas,tiempo);
        botonEnviar.setOnAction(enviarRespuesta);
    }

    public void inicializarOpciones(VoF pregunta){
        opcionesPregunta.setPrefSize(1200,200);
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.setHgap(5);
        opcionesPregunta.setVgap(5);


        for(int i = 0; i < pregunta.cantidadOpciones(); i++){
            Opcion opcionActual = pregunta.obtenerOpcion(i);
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcionBinaria vistaActual = new VistaOpcionBinaria(opcionActual,dataActual.getColor(),opcionesElegidas);

            opcionesPregunta.add(vistaActual,dataActual.getColumna(),dataActual.getFila());
            vistaActual.prefWidthProperty().bind(opcionesPregunta.widthProperty());
            vistaActual.prefHeightProperty().bind(opcionesPregunta.heightProperty());
        }
    }

    @Override
    public Pane getLayout() {
        return this;
    }

    @Override
    public void responder() {
        botonEnviar.fire();
    }
}
