package org.example.javatests.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void payment_is_correct(){

        //Como el paymentGateway no lo tenemos, lo simulamos con Mockito
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //Cuando al paymentGateway se le haga un requestPayment cualquiera, entonces
        //retorne un PaymentStatus de OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //Creamos el paymentProcessor que recibe como parametro un paymenGateway
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        //Comprobamos que cuando el paymentProcessor intenta hacer el pago de X cantidad, sera correcto
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong(){

        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        assertFalse(paymentProcessor.makePayment(1000));
    }

}