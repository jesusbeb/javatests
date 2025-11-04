package org.example.javatests;

import org.example.javatests.exercises.FizzBuzz;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

//Test para la clase FizzBuzz
public class FizzBuzzShould {


    @Test
    public void return_fizz_when_number_is_3(){
        assertThat( FizzBuzz.fizzBuzz(3), is("Fizz") );
    }

    @Test
    public void return_fizz_when_number_is_6(){
        assertThat( FizzBuzz.fizzBuzz(6), is("Fizz") );
    }

    @Test
    public void return_Buzz_when_number_is_5(){
        assertThat( FizzBuzz.fizzBuzz(5), is("Buzz") );
    }

    @Test
    public void return_Buzz_when_number_is_10(){
        assertThat( FizzBuzz.fizzBuzz(10), is("Buzz") );
    }

    @Test
    public void return_FizzBuzz_when_number_is_15(){
        assertThat( FizzBuzz.fizzBuzz(15), is("FizzBuzz") );
    }

    @Test
    public void return_FizzBuzz_when_number_is_30(){
        assertThat( FizzBuzz.fizzBuzz(30), is("FizzBuzz") );
    }

    @Test
    public void return_2_when_number_is_2(){
        assertThat( FizzBuzz.fizzBuzz(2), is("2") );
    }

    @Test
    public void return_16_when_number_is_16(){
        assertThat( FizzBuzz.fizzBuzz(16), is("16") );
    }


}