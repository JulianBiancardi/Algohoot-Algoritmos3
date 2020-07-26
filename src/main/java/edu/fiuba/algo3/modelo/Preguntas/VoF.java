package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;

public class VoF extends Pregunta {

    public VoF (String unEnunciado, ModoPregunta unModo, boolean valor) {

        //Esto se puede hacer mas lindo seguramente, no me juzguen :'(
        if(valor){
            opciones.agregarOpcion(new OpcionCorrecta("Verdadero"));
            opciones.agregarOpcion(new OpcionIncorrecta("Falso"));
        } else {
            opciones.agregarOpcion(new OpcionIncorrecta("Verdadero"));
            opciones.agregarOpcion(new OpcionCorrecta("Falso"));
        }

        cantidadCorrectas = 1;
        modo = unModo;
        enunciado = unEnunciado;
    }

    @Override
    protected void evaluarRespuesta(Respuesta respuesta) {
        //Revisar que tenga una sola opcion

        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        modo.modificarPuntos(respuesta.responsable(), cantidadCorrectas, aciertos, errores);
    }
}
