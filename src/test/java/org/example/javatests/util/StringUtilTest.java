package org.example.javatests.util;

public class StringUtilTest {
    public static void main(String[] args) {

        String result = StringUtil.repeat("Hola", 3);
        assertEquals(result, "holaholahola");

        //Simplificamos el codigo Inline. Clic en menu Refactor, Inline Variable
        //asi evitamos tener la variable result
        assertEquals(StringUtil.repeat("Hola", 1),"hola");
    }


    //Escribimos un metodo para comparar el resultado obtenido y el esperado
    //Lanzamos una excepcion en casa de haber un error y nos indicara la linea donde
    //se provoco el error.
    //Un test unitario es para probar una parte especifica del programa, en este caso
    //testeamos un metodo
    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual +" no es igual a expected: " +expected);
        }
    }
}
