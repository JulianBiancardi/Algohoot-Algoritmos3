package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exepciones.VoFSoloTieneDosOpcionesError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

public class VoF extends Pregunta {

    private VoF(String unEnunciado, ModoPregunta unModo,boolean esCorrecta)  {
        super(unEnunciado, unModo);
        agregarOpcion(new OpcionBinaria("Verdaero",esCorrecta));
        agregarOpcion(new OpcionBinaria("Falso",!esCorrecta));
    }

    public static VoF conModoClasico(String unEnunciado,boolean esCorrecta){
        return new VoF(unEnunciado, new Clasico(),esCorrecta);
    }

    public static VoF conModoPenalidad(String unEnunciado,boolean esCorrecta){
        return new VoF(unEnunciado, new Penalidad(),esCorrecta); }


    public OpcionBinaria obtenerOpcion(int posicion){ return (OpcionBinaria) super.obtenerOpcion(posicion); }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        vistaPrincipal.crearVistaVoF(stage,this);
    }

}