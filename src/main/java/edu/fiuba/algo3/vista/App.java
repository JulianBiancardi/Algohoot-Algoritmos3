package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{

    Scene sceneIntro;
    Scene scenePregunta;

    @Override
    public void start(Stage stagePrincipal) throws Exception{
        stagePrincipal.setTitle("AlgoHoot");

        ImageView fondoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");
        ImageView logoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoView.setFitHeight(100);
        logoView.setFitWidth(200);

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre");
        NombreJugador.setFocusTraversable(false);
        NombreJugador.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button("Entrar");
        botonEntrar.setOnAction(e -> stagePrincipal.setScene(scenePregunta));
        botonEntrar.setMaxWidth(Double.MAX_VALUE);

        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(e -> stagePrincipal.close());
        botonSalir.setMaxWidth(Double.MAX_VALUE);

        VBox opcionesMenu = new VBox(5,logoView,NombreJugador,botonEntrar,botonSalir);
        opcionesMenu.setMaxSize(20,20);
        opcionesMenu.setAlignment(Pos.TOP_CENTER);



        StackPane layoutPrincipal = new StackPane(fondoView,opcionesMenu);
        layoutPrincipal.setAlignment(opcionesMenu,Pos.CENTER);

        VBox layoutPrincipal2 = new VBox();
        layoutPrincipal2.getChildren().add(new Label("Enunciado de la Opcion"));
        GridPane opcionesPregunta = new GridPane();
        opcionesPregunta.add(new Button("Opcion1"),0,0);
        opcionesPregunta.add(new Button("Opcion2"),0,1);
        opcionesPregunta.add(new Button("Opcion3"),1,0);
        opcionesPregunta.add(new Button("Opcion4"),1,1);

        layoutPrincipal2.getChildren().add(opcionesPregunta);
        layoutPrincipal2.setAlignment(Pos.TOP_CENTER);



        sceneIntro = new Scene(layoutPrincipal);
        scenePregunta = new Scene(layoutPrincipal2);

        stagePrincipal.setScene(sceneIntro);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}