package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VoF extends Pregunta {

    private OpcionCorrecta opcionTrue;
    private OpcionIncorrecta opcionFalse;

    public VoF (String unEnunciado, ModoPregunta unModo, boolean valor) {

        //Esto se puede hacer mas lindo seguramente, no me juzguen :'(
        if(valor){
            OpcionCorrecta opcionTrue = new OpcionCorrecta();
            OpcionIncorrecta opcionFalse = new OpcionIncorrecta();
        } else {
            OpcionIncorrecta opcionTrue = new OpcionCorrecta();
            OpcionCorrecta opcionFalse = new OpcionIncorrecta();
        }

        opciones.agregarOpcion(opcionTrue);
        opciones.agregarOpcion(opcionFalse);

        modo = unModo;
        enunciado = unEnunciado;
    }

    @Override
    private boolean evaluarOpciones(ArrayList<Opcion> opciones){
        if(opciones.size() != 1){
            //Acá Leo se va a encargar de tirar un error y va a escribir el supuesto en el informe!!
        }

        return (opciones.get(0)).esCorrecta();
    }

    //idea by Leo
    private void evaluarRespuesta(Respuesta respuesta) {

        //Revisar que tenga una sola opcion

        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        modo.modificarPuntos(respuesta.responsable(), aciertos, errores);
    }
}
