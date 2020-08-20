package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import com.google.gson.*;
import edu.fiuba.algo3.modelo.Excepciones.FormatoDesconocidoError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class VoF extends Pregunta {
    private final ArrayList<OpcionBinaria> opcionesPregunta = new ArrayList<>();
    static final String nombre = "Verdadero o Falso";

    private VoF(String unEnunciado, ModoPregunta unModo, boolean esCorrecta)  {
        super(unEnunciado, unModo);
        opcionesPregunta.add(new OpcionBinaria("Verdadero", esCorrecta));
        opcionesPregunta.add(new OpcionBinaria("Falso", !esCorrecta));
    }

    public static VoF conModoClasico(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Clasico(), esCorrecta);
    }

    public static VoF conModoPenalidad(String unEnunciado, boolean esCorrecta){
        return new VoF(unEnunciado, new Penalidad(), esCorrecta);
    }

    public OpcionBinaria obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    @Override
    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }

    @Override
    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

    @Override
    public String tipo(){
        return nombre;
    }

    //JSON
    public static VoF recuperar(JsonObject jsonObjectVoF) {
        VoF pregunta;

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
                throw new FormatoDesconocidoError();
        }

        return pregunta;
    }

    public static VoF recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }
}