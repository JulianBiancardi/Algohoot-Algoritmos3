package edu.fiuba.algo3.modelo.Preguntas;
import edu.fiuba.algo3.modelo.Entidades.Multiplicador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PreguntaExclusividad extends Pregunta {
    private final int cantidadCorrectasPregunta; // se guarda por culpa del multiple choise
    private static int exclusividadesActivadas = 0;
    private static final int limiteJugadores = 2;
    private final List<Multiplicador> multiplicadores = List.of
                    (Multiplicador.crearMultiplicadorNulo(),
                    Multiplicador.crearMultiplicadorDoble(),
                    Multiplicador.crearMultiplicadorCuadruple());

    public PreguntaExclusividad(Pregunta pregunta) {
        super(pregunta.enunciado, pregunta.modo);
        opcionesPregunta = pregunta.opcionesPregunta;
        cantidadCorrectasPregunta = pregunta.calcularCantidadOpcionesCorrectas();
        PreguntaExclusividad.habilitarExclusividad();
    }

    private static void habilitarExclusividad() {
        exclusividadesActivadas++;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        Multiplicador multiplicadorActivo = multiplicadorParaUsarEnEstaRonda();

        int aciertosPrimerJugador = respuestas.get(0).cantidadOpcionesCorrectas();
        boolean jugadoresTodosConMismaCantidadCorrectasElegidas = respuestas.stream().allMatch(k -> k.cantidadOpcionesCorrectas() == aciertosPrimerJugador);
        boolean jugadoresNingunoSeEquivocoRespuesta = respuestas.stream().allMatch(k -> k.cantidadOpcionesIncorrectas() == 0);

        if(jugadoresNingunoSeEquivocoRespuesta && !jugadoresTodosConMismaCantidadCorrectasElegidas)
            evaluarConExclusividad(respuestas, multiplicadorActivo);
        else
            super.evaluarRespuestas(respuestas);

        exclusividadesActivadas = 0;
    }

    private void evaluarConExclusividad(ArrayList<Respuesta> respuestas, Multiplicador multiplicadorActivo) {
        // Supuesto: En Modo Parcial puntúas x4/x2 al que más options acertó :)
        Respuesta respuestaQueMasOpcionesAcerto = respuestas.stream().max(Comparator.comparingInt(Respuesta::cantidadOpcionesCorrectas)).get();
        respuestaQueMasOpcionesAcerto.agregarBeneficio(multiplicadorActivo);
        super.evaluarRespuestas(respuestas);
    }

    private Multiplicador multiplicadorParaUsarEnEstaRonda() {
        if(exclusividadesActivadas == 0)
           return multiplicadores.get(0);

        if(exclusividadesActivadas == limiteJugadores)
            return multiplicadores.get(2);
        else
            return multiplicadores.get(1);
    }

    @Override
    public int calcularCantidadOpcionesCorrectas() {
        return cantidadCorrectasPregunta;
    }
}
