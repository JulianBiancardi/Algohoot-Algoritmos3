package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;

public class VistaOpcionBinaria extends StackPane {
    ToggleButton botonEstado = new ToggleButton();

    public VistaOpcionBinaria(OpcionBinaria unaOpcion, Image imagen, ArrayList<OpcionBinaria> opcionesElegidas){
        crearVistaOpcionBinaria(unaOpcion, imagen, opcionesElegidas);
    }

    private void crearVistaOpcionBinaria(OpcionBinaria unaOpcion, Image imagen, ArrayList<OpcionBinaria> opcionesElegidas){
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
        botonEstado.setOnAction(new ControladorOpcionBinaria(opcionesElegidas, unaOpcion, botonImagenView));

        Circle bloqueDeRelleno = new Circle(20, Color.TRANSPARENT);
        botonEstado.setPadding(new Insets(0, 40, 0, 0));
        HBox textoYBoton = new HBox(bloqueDeRelleno, enunciadoPregunta, botonEstado);
        textoYBoton.setAlignment(Pos.CENTER);

        this.getChildren().addAll(fondoPregunta, textoYBoton);
    }
}
