package org.example.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    //Agregamos la anotacion Test de la libreria JUnit para indicar que es un metodo de Test
    //Lo recomendable es crear un metodo por test
    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    //Si se introduce un numero negativo, deberia crearse una excepcion que debemos
    //lanzar en el metodo StringUtil
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", -1));
    }

}