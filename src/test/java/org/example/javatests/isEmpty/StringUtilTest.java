package org.example.javatests.isEmpty;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    //True si el string esta vacio. False si el string no esta vacio.

    @Test
    public void word_is_not_empty(){
        Assert.assertFalse(StringUtil.isEmpty("Hola"));
    }

    @Test
    public void string_empty_is_empty(){
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void string_null_is_empty(){
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void string_with_multiple_spaces_is_emty(){
        assertTrue(StringUtil.isEmpty("  "));
    }

}