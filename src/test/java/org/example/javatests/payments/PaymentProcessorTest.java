package org.example.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    //Creamos este metodo para agregar las lineas de codigo repetidas en los Test, para tener
    //menos codigo. Este metodo se suele llamar setup() y se usa la anotacion @Before para
    //indicar que se tiene que ejecutar siempre antes que cualquier Test
    @Before
    public void setup(){
        //Como el paymentGateway no lo tenemos, lo simulamos con Mockito
        paymentGateway = Mockito.mock(PaymentGateway.class);
        //Creamos el paymentProcessor que recibe como parametro un paymenGateway
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct(){

        //Cuando al paymentGateway se le haga un requestPayment cualquiera, entonces
        //retorne un PaymentStatus de OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //Comprobamos que cuando el paymentProcessor intenta hacer el pago de X cantidad, sera correcto
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong(){

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }

}