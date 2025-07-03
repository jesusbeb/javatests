package org.example.javatests.player;

import java.util.Random;

//Clase de un dado
public class Dice {
    //Atributo es el numero de lados
    private int sides;

    //Constructor
    public Dice(int sides){
        this.sides = sides;
    }

    //Metodo que lanza el dado
    public int roll(){
        //Devuelve un numero aleatorio usando la clase Random que tiene el metodo nextInt que
        //genera un numero aleatorio entre cero y un numero maximo que recibe como argumento
        return new Random().nextInt(sides)+1;
    }
}
