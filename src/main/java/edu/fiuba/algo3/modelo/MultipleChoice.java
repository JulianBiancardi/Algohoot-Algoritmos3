package edu.fiuba.algo3.modelo;

public class MultipleChoice extends Pregunta {

    private int cantidadCorrectas = 0;

    public MultipleChoice (String unEnunciado, ModoPregunta unModo) {
        modo = unModo;
        enunciado = unEnunciado;
    }

    //private void modificarContadorCorrectas(){ if(...) cantidadCorrectas++; }

    public void agregarOpciones(Opcion opcion) {
        //Supuesto de al menos una correcta
        if(opciones.size() > 5)
            //Leo se encarga de programar una excepción
        opciones.agregarOpcion(Opcion);

    }

    private obtenerCantidadOpcionesCorrectas(){
        /*
        int contador = 0;
        for (Opcion opcionElegida : opcionesElegidas) {
            if(opcionElegida.esCorrecta())
                contador++;
        }
        return contador;
        */
    }

    private void evaluarRespuesta(Respuesta respuesta) {
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        int cantidadCorrectaPregunta = ;
        modo.modificarPuntos(respuesta.responsable(), aciertos, errores);
    }
}
