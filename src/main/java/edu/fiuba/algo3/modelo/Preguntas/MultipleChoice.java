package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

public class MultipleChoice extends Pregunta {

    public MultipleChoice (String unEnunciado, ModoPregunta unModo, ListaOpciones listaOpciones) {
        // [listaOpciones.cantidadOpciones() > 5 o sino nulas] lanzo excepcion
        cantidadCorrectas = listaOpciones.cantidadOpcionesCorrectas();

        modo = unModo;
        enunciado = unEnunciado;
    }

    protected void evaluarRespuesta(Respuesta respuesta) {
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        // Si aciertos o errores son nulos, lanzo excepción; necesariamente 1 respuesta correcta o incorrecta

        modo.modificarPuntos(respuesta.responsable(), cantidadCorrectas, aciertos, errores);
    }
}
