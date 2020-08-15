package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;


public class VoF extends Pregunta {

    private VoF(String unEnunciado, ModoPregunta unModo, boolean esCorrecta)  {
        super(unEnunciado, unModo);
        agregarOpcion(new OpcionBinaria("Verdadero", esCorrecta));
        agregarOpcion(new OpcionBinaria("Falso", !esCorrecta));
    }

    public static VoF conModoClasico(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Clasico(), esCorrecta);
    }

    public static VoF conModoPenalidad(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Penalidad(), esCorrecta); }

    public OpcionBinaria obtenerOpcion(int posicion){ return (OpcionBinaria) super.obtenerOpcion(posicion); }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

}