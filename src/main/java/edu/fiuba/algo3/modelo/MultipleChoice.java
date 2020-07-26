package edu.fiuba.algo3.modelo;

public class MultipleChoice extends Pregunta {

    public MultipleChoice (String unEnunciado, ModoPregunta unModo) {
        cantidadCorrectas = 0;
        modo = unModo;
        enunciado = unEnunciado;
    }

    //private void modificarContadorCorrectas(){ if(...) cantidadCorrectas++; }

    public void agregarOpciones(Opcion opcion) {
        //Supuesto de al menos una correcta
        if(opciones.cantidadOpciones() > 5)
            //Exepcion

        if(opcion.esCorrecta())
            cantidadCorrectas++;
        opciones.agregarOpcion(opcion);
    }

    protected void evaluarRespuesta(Respuesta respuesta) {
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        modo.modificarPuntos(respuesta.responsable(), cantidadCorrectas, aciertos, errores);
    }
}
