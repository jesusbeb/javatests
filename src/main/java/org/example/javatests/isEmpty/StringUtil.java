package org.example.javatests.isEmpty;

public class StringUtil {

    //Metodo para comprobar si un String esta vacio o no ("" String vacio, " " String con
    //espacios y nulos)
    //El metodo trim elimina los espacios antes y despues de un String, pero no los
    //espacios intermedios.
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}