package org.example.javatests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

//Usaremos la biblioteca de test "mockito" que sirve para simular clases.
//Esta biblioteca sirve para cuando testeamos alguna clase que colabora con otra clase a
//la cual no tenemos acceso de manera directa o cuando alguna clase devuelve valores de
//manera aleatoria que no podemos predecir entonces simulamos un valor a devolver.
public class PlayerTest {

    //Test para cuando deba perder el jugador
    @Test
    public void looses_when_dice_number_is_too_low(){

        //Dice dice = new Dice(6); //Creamos el dado con su numero de caras
        //Creamos el dado usando la libreria mockito (un mock del dado o dado simulado)
        //Simulamos que devuelve un 2. Usamos el metodo when de Mockito, para cuando el
        //dado haga un roll entonces retorne el 2
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3); //Creamos el player con su dado y el minimo numero para ganar
        assertFalse(player.play()); //Se espera que pierda
    }

    //Test para cuando deba ganar el jugador
    @Test
    public void win_when_dice_number_is_big(){

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play()); //Se espera que el jugador gane
    }

}