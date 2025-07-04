package org.example.javatests.payments;

//Clase que procesa los pagos
public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    //Constructor
    public PaymentProcessor(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    //Metodo que hace el pago y devuelve si el pago fue correcto o no
    public boolean makePayment(double amount){
        //El paymentGateway hace un requerimento de pago enviando la cantidad, el resultado
        //se almacena en response, del cual luego se obtiene el status
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        } else {
            return false;
        }
    }
}
