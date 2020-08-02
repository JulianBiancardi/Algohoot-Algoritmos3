package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.VoF;

public class Juego {

    private Jugador jugadores;
    private Pregunta pregunta;

    public void inicializar(){
        iniciarModelo();
    }

    public void iniciarModelo(){
        //Creo el modelo
        Jugador jugador1 = new Jugador("Leo");

        ListaOpciones opciones = new ListaOpciones();
        opciones.agregarOpcion(new OpcionCorrecta("Falso"));
        opciones.agregarOpcion(new OpcionIncorrecta("Verdadero"));
        VoF pregunta =  VoF.conModoClasico("2+2 = 5",opciones);
    }
}
