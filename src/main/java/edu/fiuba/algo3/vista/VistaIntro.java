package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJugar;
import edu.fiuba.algo3.controlador.ControladorSalir;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaIntro extends StackPane{

    public VistaIntro(Stage stagePrincipal){
        this.setPrefSize(600, 600);

        ImageView logoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoView.setFitHeight(100);
        logoView.setFitWidth(200);

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre");
        NombreJugador.setFocusTraversable(false);
        NombreJugador.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button("Entrar");
        botonEntrar.setMaxWidth(Double.MAX_VALUE);
        botonEntrar.setOnAction(new ControladorJugar(stagePrincipal,NombreJugador));

        Button botonSalir = new Button("Salir");
        botonSalir.setMaxWidth(Double.MAX_VALUE);
        botonSalir.setOnAction(new ControladorSalir(stagePrincipal));

        VBox opcionesMenu = new VBox(5,logoView,NombreJugador,botonEntrar,botonSalir);
        opcionesMenu.setMaxSize(20,20);
        opcionesMenu.setAlignment(Pos.TOP_CENTER);

        ImageView fondoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");

        this.getChildren().addAll(fondoView,opcionesMenu);
    }
}
