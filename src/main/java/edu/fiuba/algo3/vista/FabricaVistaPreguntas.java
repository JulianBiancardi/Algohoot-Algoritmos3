package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import javafx.stage.Stage;

public class FabricaVistaPreguntas {

    public static void crearVista(Pregunta pregunta, VistaPrincipal vistaPrincipal, Stage stage){

        if(pregunta instanceof VoF)
            vistaPrincipal.crearVistaVoF(stage,(VoF)pregunta);
        else if (pregunta instanceof MultipleChoice)
            vistaPrincipal.crearVistaMultipleChoice(stage,(MultipleChoice) pregunta);
//        else if (pregunta instanceof OrderedChoice)
          //  vistaPrincipal.crearVistaOrderedChoice(stage,(OrderedChoice) pregunta);

  /*    else if(paraPreguntaEnJuego instanceof OrderedChoice)
            return new VistaOrderedChoice(paraPreguntaEnJuego);
        else //(paraPreguntaEnJuego instanceof GroupChoice)
            return new VistaGroupChoice(paraPreguntaEnJuego);*/

    }
}
