package org.example.javatests.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    //Deberia retornar como total cero, cuando no hay precios
    @Test
    public void total_zero_when_there_are_prices(){

        PriceCalculator calculator = new PriceCalculator(); //instancia de la clase

        assertThat( calculator.getTotal(), is(0.0) );
    }

    //Deberia retornar el total esperado cuando si hay precios
    @Test
    public void total_is_the_sum_of_prices(){

        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat( calculator.getTotal(), is(25.7) );
    }

    @Test
    public void apply_discount_to_prices(){
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertThat( calculator.getTotal(), is(150.0) );
    }

}