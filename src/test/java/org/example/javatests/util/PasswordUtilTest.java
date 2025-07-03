package org.example.javatests.util;

import org.junit.Test;

import static org.example.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    //Tests para el metodo assesPassword de la clase PasswordUtil

    @Test
    public void weak_when_has_less_than_8_letters(){
        //Usamos el metodo assertEquals de JUnit, le enviamos como argumento el
        //resultado esperado, como segundo argumento llamamos el metodo a testear
        //junto con el argumento que recibe.
        assertEquals(WEAK, PasswordUtil.assesPassword("1234aS!"));
    }

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