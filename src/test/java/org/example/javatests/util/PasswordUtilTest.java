package org.example.javatests.util;

import org.junit.Test;

import static org.example.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

//Clase para crear y ejecutar desde aqui los test para el
//metodo assesPassword que esta dentro de la clase PasswordUtil
public class PasswordUtilTest {

    //Tests para el metodo assesPassword de la clase PasswordUtil

    //Comprobamos que un password sea WEAK cuando es menor de 8 caracteres
    @Test
    public void weak_when_has_less_than_8_letters(){
        //Usamos el metodo assertEquals de JUnit, le enviamos como argumento el
        //resultado esperado, como segundo argumento llamamos el metodo a testear
        //junto con el argumento que recibe.
        assertEquals(WEAK, PasswordUtil.assesPassword("1234aS!"));
    }

    //Comprobamos que un password sea WEAK cuando solo tiene letras
    @Test
    public void weak_when_has_only_letters(){
        assertEquals(WEAK, PasswordUtil.assesPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(MEDIUM, PasswordUtil.assesPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols(){
        assertEquals(STRONG, PasswordUtil.assesPassword("abcd123!"));
    }

}