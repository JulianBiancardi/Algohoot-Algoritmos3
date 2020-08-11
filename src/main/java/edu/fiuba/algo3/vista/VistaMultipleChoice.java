package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviar;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.vista.Opciones.VistaOpcion;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Opciones.VistaPregunta;
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

import java.util.HashMap;

public class VistaMultipleChoice extends VBox implements VistaPregunta {
    Button botonEnviar = new Button();
    GridPane opcionesPregunta = new GridPane();
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();

    public VistaMultipleChoice(Stage stage,MultipleChoice pregunta){

        opcionesInfo.put(0,new VistaOpcionData(0,0, Color.valueOf("#e21b3c")));
        opcionesInfo.put(1,new VistaOpcionData(0,1, Color.valueOf("#1368ce")));
        opcionesInfo.put(2,new VistaOpcionData(1,0, Color.valueOf("#d89e00")));
        opcionesInfo.put(3,new VistaOpcionData(1,1, Color.valueOf("#26890c")));
        opcionesInfo.put(4,new VistaOpcionData(2,0, Color.valueOf("#864cbf")));

        inicializarBotonEnviar(stage);
        inicializarOpciones(pregunta);

        this.getChildren().addAll(botonEnviar,opcionesPregunta);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        opcionesPregunta.maxWidthProperty().bind(this.widthProperty());
    }

    private void inicializarBotonEnviar(Stage stage){
        botonEnviar.setPrefSize(150,80);
        botonEnviar.setStyle("-fx-background-color: #26890c");

        Label label = new Label("Enviar");
        label.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        label.setTextFill(Color.WHITE);
        botonEnviar.setGraphic(label);

        ControladorEnviar enviarRespuesta = new ControladorEnviar(stage);
        botonEnviar.setOnAction(enviarRespuesta);
    }

    private void inicializarOpciones(MultipleChoice pregunta){
        if (pregunta.cantidadOpciones() > opcionesInfo.size()) // lanzar exepcion, cantidad de opciones incorrectas
            return;

        opcionesPregunta.setPrefSize(1200,200);
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.setHgap(5);
        opcionesPregunta.setVgap(5);

        for(int i = 0; (i < pregunta.cantidadOpciones()); i++){
            Opcion opcionActual = pregunta.obtenerOpcion(i);
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcion vistaActual = new VistaOpcion(opcionActual,dataActual.getColor());

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
    public void responder(){
        botonEnviar.fire();
    }

}
