package com.carFactory.diyCar.utils.clientGreeters;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class StandardClientGreeter implements ClientGreeter{
    @Override
    public void greetClient() {
        System.out.println("Greetings, dear client!");
    }
}
