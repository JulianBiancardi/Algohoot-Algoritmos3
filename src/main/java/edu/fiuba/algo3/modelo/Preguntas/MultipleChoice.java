package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.PreguntaMultipleChoiseCreadaConListaOpcionesDeCantidadInvalidaExcepcion;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.PuntajeParcial;

public class MultipleChoice extends Pregunta {

    private MultipleChoice(String Enunciado, ModoPregunta Modo, ListaOpciones opcionesPregunta) {
        if(opcionesPregunta.obtenerCantidadOpciones() < 2 || opcionesPregunta.obtenerCantidadOpciones() > 5)
            throw new PreguntaMultipleChoiseCreadaConListaOpcionesDeCantidadInvalidaExcepcion();
        // No te dejar usar super() si usas ese if
        enunciado = Enunciado;
        modo = Modo;
        cantidadOpcionesCorrectas =  opcionesPregunta.cantidadOpcionesCorrectas();
    }

    public static MultipleChoice crearEnModoClasico(String contenido, ListaOpciones opcionesPregunta) {
        return new MultipleChoice(contenido, new Clasico(), opcionesPregunta);
    }
    public static MultipleChoice crearEnModoPenalizado(String contenido, ListaOpciones opcionesPregunta) {
        return new MultipleChoice(contenido, new Penalidad(), opcionesPregunta);
    }
    public static MultipleChoice crearEnModoParcial(String contenido, ListaOpciones opcionesPregunta) {
        return new MultipleChoice(contenido, new PuntajeParcial(), opcionesPregunta);
    }
}