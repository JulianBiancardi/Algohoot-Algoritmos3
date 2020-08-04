package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class VoF extends Pregunta {

    private VoF(String Enunciado, ModoPregunta Modo, ListaOpciones opcionesPregunta)  {
        enunciado = Enunciado;
        modo = Modo;
        cantidadOpcionesCorrectas =  opcionesPregunta.cantidadOpcionesCorrectas();
    }

    public static VoF crearEnModoClasico(String contenido, OpcionCorrecta opcionCorrecta) {
        return new VoF(contenido, new Clasico(), obtenerLista(opcionCorrecta));
    }

    public static VoF crearEnModoPenalizado(String contenido, OpcionCorrecta opcionCorrecta) {
        return new VoF(contenido, new Penalidad(), obtenerLista(opcionCorrecta));
    }

    // Preguntar a Martín para evitar crear este método
    private static ListaOpciones obtenerLista(OpcionCorrecta opcion){
        ListaOpciones lista = new ListaOpciones();
        lista.agregarOpcion(opcion);
        return lista;
    }
}