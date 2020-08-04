package edu.fiuba.algo3.modelo.Entidades;

public class Jugador {
    private final String nombre;
    private final Puntuacion puntuacionJugador;
    private final static int idMultiDoble = 1;
    private final static int idMultiTriple = 2;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntuacionJugador = new Puntuacion();
        puntuacionJugador.agregarMultiplicador(idMultiDoble, Multiplicador.crearConFactor(2));
        puntuacionJugador.agregarMultiplicador(idMultiTriple, Multiplicador.crearConFactor(3));
    }

    public void utilizarMultiplicador(int identificador) {
        puntuacionJugador.utilizarMultiplicador(identificador);
    }

    public void puntuarJugador(CriterioPuntuacion criterioPuntuacion, int aciertosJugador) {
        criterioPuntuacion.puntuar(puntuacionJugador, aciertosJugador);
    }

    public void penalizarJugador(CriterioPuntuacion criterioPuntuacion, int erroresJugador) {
        criterioPuntuacion.penalizar(puntuacionJugador, erroresJugador);
    }

    // sólo para test:
    public int puntos() {
        return puntuacionJugador.obtenerPuntos();
    }
    public String nombre() {
        return nombre;
    }
    public int cantidadMultiplicadores() {
        return puntuacionJugador.cantidadMultiplicadores();
    }
    public static int identificadorMultiplicadorDoble() {
        return idMultiDoble;
    }
    public static int identificadorMultiplicadorTriple() {
        return idMultiTriple;
    }
}
