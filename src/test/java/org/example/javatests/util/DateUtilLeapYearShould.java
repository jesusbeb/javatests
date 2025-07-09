package org.example.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

//Existe otra corriente donde los nombres de test terminan con la palabra Should y
//los nombres de los Test continuan la frase despues de Should (deberia)
public class DateUtilLeapYearShould {
    /*
        Para calcular un año bisiesto, se usan estas 4 reglas:
        All years divisible by 400 ARE leap years (1600, 2000, 2400)
        All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900)
        All years divisible by 4 but no by 100 ARE leap years (1996, 2004, 2008)
        All years not divisible by 4 are NOT leap years (2017, 2018, 2019)
    */

    @Test
    public void return_true_when_year_is_divisible_by_400(){

        assertThat(DateUtilLeapYear.isLeapYear(1600), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2000), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2400), is(true));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_by_400(){

        assertThat(DateUtilLeapYear.isLeapYear(1700), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(1800), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(1900), is(false));
    }

    @Test
    public void return_true_when_year_is_divisible_by_4_but_not_by_100(){
        assertThat(DateUtilLeapYear.isLeapYear(1956), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2004), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2008), is(true));
    }

    @Test
    public void return_false_when_year_is_not_divisible_by_4() {

        assertThat(DateUtilLeapYear.isLeapYear(2017), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(2018), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(2019), is(false));
    }
}


/*
El Test Driven Development (TDD) o desarrollo guiado por test, creado por Kent Beck,
consiste en escribir primero los test antes que las clases permitiéndote ver si el
diseño de una clase es la adecuada.

El ciclo del TDD
Red: escribe un test que falle.
Green: escribe el código necesario para que pase el test.
Refactor: mejora el código.

Reglas
Sólo escribirás código de test hasta que falle.
Sólo escribirás código de producción para pasar el test.
No escribirás más código de producción del necesario.

Puedes combinar las reglas del TDD con su ciclo tal como hizo el profesor:
Red: Escribirás el mínimo de código test que falle.
Green: Escribirás el mínimo de código de producción que pase el test.
Refactor: sólo cuando los tests estén pasando.
*/