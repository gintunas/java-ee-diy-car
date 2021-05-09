package com.carFactory.diyCar.utils.payments;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@RequestScoped
public class FancyPaymentProcessor extends PaymentProcessor{

    @Override
    public void pay() {
        super.pay();
        System.out.println("Pay some more.");
    }
}
