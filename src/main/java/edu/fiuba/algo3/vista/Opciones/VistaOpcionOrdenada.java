package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class VistaOpcionOrdenada extends StackPane {
    private Label posicionActual = new Label();
    private Button botonEstado = new Button();

    public VistaOpcionOrdenada(OpcionOrdenada unaOpcion, Image imagen, ArrayList<OpcionOrdenada> opcionesElegidas, int cantidadOpciones){
        ImageView fondoPregunta = new ImageView(imagen);
        Label enunciadoPregunta = VistaEnunciado.obtenerLabelResponsive(unaOpcion);

        enunciadoPregunta.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        enunciadoPregunta.setTextFill(Color.WHITE);
        enunciadoPregunta.setPrefSize(350, 60);
        enunciadoPregunta.setAlignment(Pos.CENTER);

        Image botonImagen = new Image(ConstantesAlgohoot.PREGUNTA_NO_SELECCIONADA);
        ImageView botonImagenView = new ImageView(botonImagen);
        botonImagenView.setFitHeight(60);
        botonImagenView.setFitWidth(60);
        botonEstado.setGraphic(botonImagenView);
        botonEstado.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, Insets.EMPTY)));
        botonEstado.setOnAction(new ControladorOpcionOrdenada(opcionesElegidas, unaOpcion, posicionActual));

        posicionActual.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        posicionActual.setTextFill(Color.WHITE);


        Circle bloqueDeRelleno = new Circle(20, Color.TRANSPARENT);
        StackPane selectorBoton = new StackPane(botonEstado, posicionActual);
        selectorBoton.setPadding(new Insets(0, 40, 0, 0));
        HBox textoYBoton = new HBox(bloqueDeRelleno, enunciadoPregunta, selectorBoton);
        textoYBoton.setAlignment(Pos.CENTER);

        this.getChildren().addAll(fondoPregunta, textoYBoton);
    }

    public void resetLabel(){
        posicionActual.setText("");
    }
}
