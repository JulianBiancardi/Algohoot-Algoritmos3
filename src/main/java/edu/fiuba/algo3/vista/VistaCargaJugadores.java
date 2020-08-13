package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJugar;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaCargaJugadores extends StackPane{

    private Juego juego;

    public VistaCargaJugadores(Stage stagePrincipal, Juego juego){
        this.juego = juego;

        this.setPrefSize(600, 600);

        ImageView logoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoView.setFitHeight(100);
        logoView.setFitWidth(200);

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre Jugador 1");
        NombreJugador.setFocusTraversable(false);
        NombreJugador.setAlignment(Pos.CENTER);

        TextField NombreJugador2 = new TextField();
        NombreJugador2.setPromptText("Nombre Jugador 2");
        NombreJugador2.setFocusTraversable(false);
        NombreJugador2.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button("Entrar");
        botonEntrar.setMaxWidth(Double.MAX_VALUE);
        botonEntrar.setOnAction(new ControladorJugar(stagePrincipal,NombreJugador,NombreJugador2,juego));

        Button botonSalir = new Button("Salir");
        botonSalir.setMaxWidth(Double.MAX_VALUE);
        botonSalir.setOnAction(new ControladorSalir());

        VBox opcionesMenu = new VBox(5,logoView,NombreJugador,NombreJugador2,botonEntrar,botonSalir);
        opcionesMenu.setMaxSize(20,20);
        opcionesMenu.setAlignment(Pos.TOP_CENTER);

        ImageView fondoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");

        this.getChildren().addAll(fondoView,opcionesMenu);
    }

    public void mostarErrorNombre(){
        System.out.println("error de nombre");
    }
}
