package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.*;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.PuntajeParcial;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MultipleChoice extends Pregunta {
    private final ArrayList<OpcionBinaria> opcionesPregunta = new ArrayList<>();

    private MultipleChoice(String unEnunciado, ModoPregunta unModo) {
        super(unEnunciado, unModo);
    }

    public static MultipleChoice conModoClasico(String unEnunciado){ return new MultipleChoice(unEnunciado, new Clasico()); }

    public static MultipleChoice conModoPenalidad(String unEnunciado){ return new MultipleChoice(unEnunciado, new Penalidad()); }

    public static MultipleChoice conModoPuntajeParcial(String unEnunciado){ return new MultipleChoice(unEnunciado, new PuntajeParcial()); }

    private void agregarOpcion(OpcionBinaria opcion){
        opcionesPregunta.add(opcion);
    }

    public void nuevaOpcion(String descripcion, boolean esCorrecta){
        if(opcionesPregunta.size() == 5)
            throw new ChoiceTieneMaxCincoOpcionesError();
        agregarOpcion(new OpcionBinaria(descripcion, esCorrecta));
    }

    public OpcionBinaria obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

    @Override
    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }


    //JSON

    public static MultipleChoice recuperar(JsonObject jsonObjectMC) {
        MultipleChoice pregunta = null;

        String enunciadoPregunta = jsonObjectMC.get("Descripcion").getAsString();
        String modoPregunta = jsonObjectMC.get("Modo").getAsString();

        switch (modoPregunta){
            case "Clasico":
                pregunta = MultipleChoice.conModoClasico(enunciadoPregunta);
                break;
            case "PuntajeParcial":
                pregunta = MultipleChoice.conModoPuntajeParcial(enunciadoPregunta);
                break;
            case "Penalidad":
                pregunta = MultipleChoice.conModoPenalidad(enunciadoPregunta);
                break;
            default:
                //Excepcion o elegir un caso como default
                break;
        }


        JsonArray arrayOpciones = jsonObjectMC.getAsJsonArray("Opciones");
        for (JsonElement jsonOpcion : arrayOpciones) {
            JsonElement jsonObjectOpcion = jsonOpcion;
            //JsonElement jsonObjectNota = jsonNota;
            //Nota nota = Nota.recuperar(jsonObjectNota.getAsJsonObject());
            OpcionBinaria opcion = OpcionBinaria.recuperar(jsonObjectOpcion.getAsJsonObject());
            pregunta.agregarOpcion(opcion);
        }

        /*
        if(modoPregunta.equals("Clasico")){
            pregunta = VoF.conModoClasico(enunciadoPregunta, valorPregunta);
        } else {
            pregunta = VoF.conModoPenalidad(enunciadoPregunta, valorPregunta);
        }
        */

        /*
        JsonArray arrayNotas = jsonObjectAnotador.getAsJsonArray("notas");
        for (JsonElement jsonNota : arrayNotas) {
            JsonElement jsonObjectNota = jsonNota;
            Nota nota = Nota.recuperar(jsonObjectNota.getAsJsonObject());
            anotador.addNota(nota);
        }
        */
        return pregunta;
    }

    public static MultipleChoice recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        vistaPrincipal.crearVistaMultipleChoice(stage,this);

    }
}
