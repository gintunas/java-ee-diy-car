package com.carFactory.diyCar.utils.clientGreeters;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@Alternative
public class FancyClientGreeter implements ClientGreeter{
    @Override
    public void greetClient() {
        System.out.println("Greetings, our dearest friend, we are so happy to see you!");
    }
}
