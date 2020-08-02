package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.vista.VistaIntro;
import edu.fiuba.algo3.vista.VistaJugador;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        VistaIntro introVista = new VistaIntro();

        Jugador jugador = new Jugador("Joaco");
        VistaJugador jugadorVista = new VistaJugador(jugador);

        VistaPregunta preguntaVista = new VistaPregunta();

        stagePrincipal.setScene(preguntaVista.getScene());
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}