package org.example.javatests.payments;

//Hacemos una interface de una pasarela de pago, pero no la implementaremos porque
//no la tenemos, la usamos a traves de una biblioteca.
public interface PaymentGateway {

    //Metodo
    PaymentResponse requestPayment(PaymentRequest request);
}
