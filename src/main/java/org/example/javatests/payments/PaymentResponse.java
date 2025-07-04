package org.example.javatests.payments;

//Esta clase contiene un codigo de respuesta del pago con dos status
public class PaymentResponse {

    enum PaymentStatus{
        OK, ERROR
    }

    private PaymentStatus status;


    //Constructor
    public PaymentResponse(PaymentStatus status){
        this.status = status;
    }

    //Getter
    public PaymentStatus getStatus(){
        return status;
    }
}
