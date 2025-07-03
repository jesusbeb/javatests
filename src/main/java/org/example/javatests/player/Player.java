package org.example.javatests.player;

//Clase para un jugador que lanza un dado de n caras y para ganar debe obtener un
//numero minimo que se indique
public class Player {
    //Tiene como atributos, un dado y un numero minimo para ganar
    private Dice dice;
    private int minNumberToWin;

    //Constructor
    public Player(Dice dice, int minNumberToWin){
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    //Metodo que devuelve si ha ganado o perdido
    public boolean play(){
        int diceNumber = dice.roll(); //Lanza el dado
        return diceNumber >= minNumberToWin; //Gana cuando sale el minimo numero para ganar que se indique
    }
}
