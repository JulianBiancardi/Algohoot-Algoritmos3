package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class VistaOpcionGrupal extends StackPane {
    OpcionGrupal opcionAsociada;
    private Label grupoActualLabel = new Label();
    private Button botonEstado = new Button();

    public VistaOpcionGrupal(OpcionGrupal unaOpcion, Image imagen, ArrayList<OpcionGrupal> opcionesGrupoA, ArrayList<OpcionGrupal> opcionesGrupoB){
        opcionAsociada = unaOpcion;
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
        botonEstado.setOnAction(new ControladorOpcionGrupal(opcionesGrupoA, opcionesGrupoB, opcionAsociada, grupoActualLabel));

        grupoActualLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        grupoActualLabel.setTextFill(Color.WHITE);
        grupoActualLabel.setMouseTransparent(true);

        Circle bloqueDeRelleno = new Circle(20, Color.TRANSPARENT);
        StackPane selectorBoton = new StackPane(botonEstado, grupoActualLabel);
        selectorBoton.setPadding(new Insets(0, 40, 0, 0));
        HBox textoYBoton = new HBox(bloqueDeRelleno, enunciadoPregunta, selectorBoton);
        textoYBoton.setAlignment(Pos.CENTER);

        this.getChildren().addAll(fondoPregunta, textoYBoton);

    }
}
