[![Build Status](https://travis-ci.com/JulianBiancardi/Algoritmos3---TP2.svg?token=EKxdtGcYaBFNUkEovYrj&branch=master)](https://travis-ci.com/JulianBiancardi/Algoritmos3---TP2)
[![codecov](https://codecov.io/gh/JulianBiancardi/Algoritmos3---TP2/branch/master/graph/badge.svg?token=HGKUYEBHKW)](https://codecov.io/gh/JulianBiancardi/Algoritmos3---TP2)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Grupo de TP](https://img.shields.io/badge/N%C2%B0%20Grupo-9-blue)](https://github.com/JulianBiancardi/Algoritmos3---TP2)
[![Materia e Institución](https://img.shields.io/badge/Algoritmos%20y%20Programaci%C3%B3n%20III-FIUBA-red)](https://campus.fi.uba.ar/course/view.php?id=210)

# Trabajo Práctico N°2: Algohoot!

Este juego, inspirado en el original [Kahoot](https://kahoot.com/), es parte del trabajo final y grupal realizado para la materia de **Algoritmos y Programación III** dictada en la **Facultad de Ingeniería de la Universidad 
de Buenos Aires (FIUBA)** durante el primer cuatrimestre del 2020.


Para la parte del modelo se utilizó un lenguaje de tipado estático, **Java**, con un diseño orientado a objetos trabajando con las técnicas de TDD e Integración Continua. 


Para la parte de interacción entre el usuario y la aplicación se decidió realizar una interfaz gráfica intuitiva con **JavaFX**.

## Integrantes - Grupo 9

Nombre | Padrón | Email
------ | ------| -------------
[BIANCARDI, Julian](https://github.com/JulianBiancardi) | 103945 | jbiancardi@fi.uba.ar
[HETREA, Joaquín Emanuel](https://github.com/JoaquinHetrea) | 103944 | jhetrea@fi.uba.a
[TARDITI PELLEGRINO, Leo Damian](https://github.com/leotarditi) | 104521 | ltarditi@fi.uba.ar
[GALIAN, Tomás Ezequiel](https://github.com/TomiGalian) | 104354 | tgalian@fi.uba.ar
[PACHECO, Federico Jose](https://github.com/fjpacheco) | 104541 | fpacheco@fi.uba.ar
     
Corrector: **[PICCO, Martín Alejandro](https://github.com/M-Picco)**

### Ver el informe completo [aquí](https://github.com/JulianBiancardi/Algoritmos3---TP2/blob/master/Grupo9-tp2s.pdf)

## Imagenes de la aplicación

![Inicio](/Imagenes/Inicio.png)

![VoF](/Imagenes/VerdaderoFalso.png)

![MultipleChoice](/Imagenes/MultipleChoice.png)

![OrderedChoice](/Imagenes/OrderedChoice.png)

![GroupChoice](/Imagenes/GroupChoice.png)

![Random](/Imagenes/Random.png)

### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

```
java 11
maven 3.6.0
```

## Ejecutando las pruebas

```bash
    mvn clean test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

Para ejecutar la aplicación se debe ejecutar el siguiente comando:

```bash
    mvn clean javafx:run
```
## Licencia

Este repositorio está bajo la Licencia MIT
