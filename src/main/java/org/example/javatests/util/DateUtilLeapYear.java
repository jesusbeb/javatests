package org.example.javatests.util;

//Al aplicar la tecnica TDD, primero se crean los Tests y despues se implementa este metodo,
//por lo que primero lo hacemos que solo retorne true para hacer pasar los test.
//Despues de tener el segundo Test podemos empezar a implementar este metodo.
public class DateUtilLeapYear {

    public static boolean isLeapYear(int year){
        if ( (year%4 == 0 && year%100 !=0) || (year % 400 == 0) ){
            return true;
        } else {
            return false;
        }
    }
}
