package com.carFactory.diyCar.utils.payments;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PaymentProcessor {
    public void pay(){
        System.out.println("Pay simply.");
    }
}
