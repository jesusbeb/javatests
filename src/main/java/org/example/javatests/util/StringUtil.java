package org.example.javatests.util;

//Clase de utilidad
//Sobre el nombre de la clase podemos dar clic derecho, seleccionar Generate...,
//Test..., escogemos JUnit4 y damos ok. Se creara una clase de Test con el mismo
//nombre y la palabra Test al final
public class StringUtil {

    //Metodo de prueba para repetir Strings
    public static String repeat(String str, int times){

        //Excepcion en caso de introducir numeros negativos
        if(times <0){
            throw new IllegalArgumentException("numeros negativos no estan permitidos");
        }

        String result = "";

        for (int i=0; i<times; i++){
            result += str;
        }

        return result;
    }
}
