package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class VoF extends Pregunta {
    private final ArrayList<OpcionBinaria> opcionesPregunta = new ArrayList<>();
    boolean valor;

    private VoF(String unEnunciado, ModoPregunta unModo, boolean esCorrecta)  {
        super(unEnunciado, unModo);
        valor = esCorrecta;
        opcionesPregunta.add(new OpcionBinaria("Verdaero", esCorrecta));
        opcionesPregunta.add(new OpcionBinaria("Falso", !esCorrecta));
    }

    public static VoF conModoClasico(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Clasico(), esCorrecta);
    }

    public static VoF conModoPenalidad(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Penalidad(), esCorrecta); }

    public OpcionBinaria obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

    @Override
    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }

    //JSON
    public static VoF recuperar(JsonObject jsonObjectVoF) {
        VoF pregunta = null;

        String enunciadoPregunta = jsonObjectVoF.get("Enunciado").getAsString();
        boolean valorPregunta = jsonObjectVoF.get("Valor").getAsBoolean();
        String modoPregunta = jsonObjectVoF.get("Modo").getAsString();

        switch (modoPregunta){
            case "Clasico":
                pregunta = VoF.conModoClasico(enunciadoPregunta, valorPregunta);
                break;
            case "Penalidad":
                pregunta = VoF.conModoPenalidad(enunciadoPregunta, valorPregunta);
                break;
            default:
                //Excepcion o elegir un caso como default
                break;
        }

        return pregunta;
    }

    public static VoF recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        vistaPrincipal.crearVistaVoF(stage,this);
    }
}