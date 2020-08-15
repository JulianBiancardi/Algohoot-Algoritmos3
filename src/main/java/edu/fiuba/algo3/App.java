package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.VistaCargaJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{

    private Juego juego = new Juego();

    @Override
    public void start(Stage stagePrincipal) throws Exception{

        stagePrincipal.setTitle("AlgoHoot");

        VistaCargaJugadores introVista = new VistaCargaJugadores(stagePrincipal,juego);
        //VistaOpcionBinaria introVista = new VistaOpcionBinaria(new OpcionBinaria("hola",true), Color.AQUA);
        stagePrincipal.setScene(new Scene(introVista));
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}