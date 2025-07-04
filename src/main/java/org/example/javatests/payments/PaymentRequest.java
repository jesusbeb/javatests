package org.example.javatests.payments;

//Esta clase hace la solicitud de pago
public class PaymentRequest {
    //Atributo para cantidad
    private double amount;

    //Constructor
    public PaymentRequest(double amount){
        this.amount = amount;
    }

    //Getter
    public double getAmount(){
        return amount;
    }
}
