package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

public class MultipleChoice extends Pregunta {

    public MultipleChoice (String unEnunciado, ModoPregunta unModo) {
        cantidadCorrectas = 0;
        modo = unModo;
        enunciado = unEnunciado;
    }

    //private void modificarContadorCorrectas(){ if(...) cantidadCorrectas++; }

    public void agregarOpciones(Opcion unaOpcion) {
        //Supuesto de al menos una correcta
        if(opciones.cantidadOpciones() > 5) {
            //Exepcion
        }
        if(unaOpcion.esCorrecta()) {
            cantidadCorrectas++;
        }
        opciones.agregarOpcion(unaOpcion);
    }

    protected void evaluarRespuesta(Respuesta respuesta) {
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        modo.modificarPuntos(respuesta.responsable(), cantidadCorrectas, aciertos, errores);
    }
}
