package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.ResourcesConstantsAlgohoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorAcercaDe implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent){

        Alert alert = new Alert(Alert.AlertType.NONE);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(ResourcesConstantsAlgohoot.ICONO_ALGOHOOT));
        ImageView imagen = new ImageView(ResourcesConstantsAlgohoot.ICONO_ALGOHOOT);
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        alert.setGraphic(imagen);

        alert.setTitle("Acerca de");
        alert.setHeaderText("Trabajo Práctico N°2: algohoot!\nAlgoritmos y Programación III - FIUBA");
        String mensaje =
                "Este juego, inspirado en el juego original Kahoot, es parte del " +
                "trabajo final y grupal para la materia de " +
                "Algoritmos y Programación III " +
                "dictada en la Facultad de Ingeniería de la Universidad de Buenos Aires.\n" +

                "Se trabajo con un lenguaje de tipado estático (Java) y " +
                "principalmente con un diseño del modelo orientado a objetos. " +
                "Para el desarrollo de dicho trabajo participaron los siguientes alumnos:\n\n" +

                "Julian Biancardi\n" +
                "Joaquin Hetrea\n" +
                "Leo Tarditi\n" +
                "Tomas Galian\n" +
                "Federico Pacheco\n";

        alert.setContentText(mensaje);
        ButtonType salir = new ButtonType("Cerrar", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().addAll(salir);

        alert.show();
    }
}
