package org.example.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    //Agregamos la anotacion Test de la libreria JUnit para indicar que es un metodo de Test
    //No se utiliza el metodo main
    @Test
    public void testRepeat() {

        //Hacemos dos test al metodo repeat, pero ahora usando el metodo assertEquals de JUnit
        //Enviamos como argumentos el String esperado y luego llamamos al metodo enviando los
        //argumentos para testear
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

}
