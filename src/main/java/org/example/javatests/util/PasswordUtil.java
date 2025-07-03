package org.example.javatests.util;

public class PasswordUtil {

    //Definimos tres niveles de seguridad
    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    //Este metodo comprueba el nivel de seguridad de un password y retorna alguno
    //de los tres niveles de seguridad definidos en el enum
    public static SecurityLevel assesPassword(String password){

        //Cuando el password es menor de 8 caracteres
        if (password.length() < 8){
            return SecurityLevel.WEAK;
        }

        //Cuando el password solo tiene letras. El metodo matches recibe una expresion
        //regular, en este caso se indica un rango de la A a la Z en minusculas y
        //mayusculas, con el simbolo + se indica que se pueden repetir las letras varias veces
        if (password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        //Cuando el password tiene letras y numeros, que se pueden repetir varias veces (+)
        if (password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        //Cuando ademas de las condiciones anteriores tiene simbolos entonces es STRONG
        return SecurityLevel.STRONG;
    }
}
