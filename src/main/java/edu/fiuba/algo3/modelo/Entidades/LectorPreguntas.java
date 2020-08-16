package edu.fiuba.algo3.modelo.Entidades;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LectorPreguntas {
    private JsonArray jsonPreguntas;

    public LectorPreguntas() throws IOException {
        String texto = Files.readString(Path.of("preguntas/preguntas.json"));
        JsonObject jsonObjectP = JsonParser.parseString(texto).getAsJsonObject();
        jsonPreguntas = jsonObjectP.getAsJsonArray("Preguntas");
    }

    public ArrayList<Pregunta> leerPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        for(JsonElement jsonPregunta: jsonPreguntas) {
            String tipoPregunta = (jsonPregunta.getAsJsonObject()).get("Tipo").getAsString();
            JsonArray preguntasTipo;
            switch(tipoPregunta){
                case "VoF":
                    preguntasTipo = (jsonPregunta.getAsJsonObject()).getAsJsonArray("PreguntasVoF");
                    for (JsonElement jsonVoF : preguntasTipo) {
                        VoF pregunta = VoF.recuperar(jsonVoF.getAsJsonObject());
                        preguntas.add(pregunta);
                    }
                    break;
                case "MultipleChoice":
                    preguntasTipo = (jsonPregunta.getAsJsonObject()).getAsJsonArray("PreguntasMC");
                    for (JsonElement jsonMC :  preguntasTipo) {
                        MultipleChoice pregunta = MultipleChoice.recuperar(jsonMC.getAsJsonObject());
                        preguntas.add(pregunta);
                    }
                    break;
                case "OrderedChoice":
                    preguntasTipo = (jsonPregunta.getAsJsonObject()).getAsJsonArray("PreguntasOC");
                    for (JsonElement jsonOC :  preguntasTipo) {
                        OrderedChoice pregunta = OrderedChoice.recuperar(jsonOC.getAsJsonObject());
                        preguntas.add(pregunta);
                    }
                    break;
                case "GroupChoice":
                    preguntasTipo = (jsonPregunta.getAsJsonObject()).getAsJsonArray("PreguntasGC");
                    for (JsonElement jsonGC :  preguntasTipo) {
                        GroupChoice pregunta = GroupChoice.recuperar(jsonGC.getAsJsonObject());
                        preguntas.add(pregunta);
                    }
                    break;
                default:
                    //Excepcion
                    break;
            }
        }

        return preguntas;
    }
}
