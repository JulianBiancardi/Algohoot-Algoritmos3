package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Multiplicador;
import edu.fiuba.algo3.modelo.Entidades.Puntuacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuacionTest {

    @Test
    public void test01PuntuacionArrancaConPuntajeNuloAlCrearse(){
        Puntuacion puntuacion = new Puntuacion();
        assertEquals(0, puntuacion.obtenerPuntos());
    }

    @Test
    public void test02PuntuacionPermiteAgregarMultiplicadoresConSuIdentificador(){
        Puntuacion puntuacion = new Puntuacion();
        Multiplicador multiplicador = Multiplicador.crearSinEfecto();

        puntuacion.agregarMultiplicador(1, multiplicador);

        assertEquals(multiplicador, puntuacion.obtenerMultiplicadorDeId(1));
    }

    @Test
    public void test03PuntuacionPermiteModificarSuPuntajeSegunFactorConAciertosRecibidos(){
        Puntuacion puntuacion = new Puntuacion();

        puntuacion.modificarPuntos(10, 5);

        assertEquals(10*5, puntuacion.obtenerPuntos());
    }

    @Test
    public void test04SiNoSeActivaMultiplicadorEntoncesAlModificarPuntajeConModificadorNoHaraEfectoAlPuntuar(){
        Puntuacion puntuacion = new Puntuacion();
        Multiplicador multiplicador = Multiplicador.crearConFactor(100);
        puntuacion.agregarMultiplicador(1, multiplicador);

        puntuacion.modificarPuntosConMultiplicador(100, 2);

        assertEquals(100*2, puntuacion.obtenerPuntos());
    }

    @Test
    public void test05SiSeActivaMultiplicadorEntoncesAlModificarPuntajeConModificadorHaraEfectoAlPuntuar(){
        Puntuacion puntuacion = new Puntuacion();
        Multiplicador multiplicador = Multiplicador.crearConFactor(100);
        puntuacion.agregarMultiplicador(1, multiplicador);

        puntuacion.utilizarMultiplicador(1);
        puntuacion.modificarPuntosConMultiplicador(100, 2);

        assertEquals(100*100*2, puntuacion.obtenerPuntos());
    }

    @Test
    public void test06SiSeActivaElMismoEfectoMultiplicadorMasDe1VezSoloHaraEfecto1SolaVezAlPuntuarDosVecesConElMismoMultiplicador(){
        Puntuacion puntuacion = new Puntuacion();
        int factorMultiplicador = 2; // doble puntaje
        Multiplicador multiplicador = Multiplicador.crearConFactor(factorMultiplicador);
        puntuacion.agregarMultiplicador(1, multiplicador);

        int puntosEsperados_1 = factorMultiplicador * 100 * 2;
        puntuacion.utilizarMultiplicador(1);
        puntuacion.modificarPuntosConMultiplicador(100, 2);
        assertEquals(puntosEsperados_1, puntuacion.obtenerPuntos());

        Integer puntosEsperados_2 = puntosEsperados_1 + (10 * 5) ; // solo 1 vez contabiliza el multiplicador
        puntuacion.utilizarMultiplicador(1);
        puntuacion.modificarPuntosConMultiplicador(10, 5);
        assertEquals(puntosEsperados_2, puntuacion.obtenerPuntos());
    }

}
