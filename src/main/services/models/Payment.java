package src.main.services.models;

import src.main.enums.PaymentStatus;

import java.time.LocalDate;

public class Payment {
    private LocalDate creationDate;

    private long amount;

    private PaymentStatus paymentStatus;

    public Payment() {
        this.creationDate = LocalDate.now();

        paymentStatus = PaymentStatus.NOT_PAID;
    }

    public Boolean initiateTransaction(Double payedAmount) {

        // call to payment service with the amount
        // If successful then set to True otherwise False
        Boolean isSuccessful = true;

        if(isSuccessful) {
            paymentStatus = PaymentStatus.PAID;
            System.out.println("Amount of " + payedAmount.toString() + " paid!");
            return true;
        } else {
            paymentStatus = PaymentStatus.NOT_PAID;
            System.out.println("Transcation Error! Please try again.");
            return false;
        }
    }
}