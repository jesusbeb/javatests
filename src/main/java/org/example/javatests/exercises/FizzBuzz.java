package org.example.javatests.exercises;


//Clase con el metodo fizzbuzz
public class FizzBuzz {
    

    //Si el numero es divisible entre 3, se retorna Fizz
    //Si el numero es divisible entre 5, se retorna Buzz
    //Si el numero es divisible entre 3 y 5, se retorna FizzBuzz
    //En cualquier otro caso, se retorna el mismo numero como String
    public static String fizzBuzz (int n){
        if (n%3 == 0 & n%5 == 0){
            return "FizzBuzz";
        } else if (n%3 == 0) {
            return "Fizz";
        } else if (n%5 == 0){
            return "Buzz";
        } else
            return String.valueOf(n);
    }
}
