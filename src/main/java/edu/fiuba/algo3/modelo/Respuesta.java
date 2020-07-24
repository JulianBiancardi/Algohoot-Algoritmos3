package edu.fiuba.algo3.modelo;

public class Respuesta {
    private Opcion opcionElegida;
    private final Jugador responsable;

    public Respuesta(Opcion unaOpcion, Jugador jugador) {
      opcionElegida = unaOpcion;
      responsable = jugador;
    }

    public boolean esCorrecta() { return opcionElegida.esCorrecta(); }

    public Opcion valor() { return opcionElegida; }

    public Jugador responsable() { return responsable; }

    public void sumarPuntos(int puntaje) {
        responsable.sumarPuntos(puntaje);
    }

    public void restarPuntos(int puntaje) { responsable.restarPuntos(puntaje); }
}
