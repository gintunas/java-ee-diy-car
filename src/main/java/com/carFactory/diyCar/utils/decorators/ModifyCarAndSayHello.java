package com.carFactory.diyCar.utils.decorators;

import com.carFactory.diyCar.usecases.ModifyCar;
import com.carFactory.diyCar.usecases.SimpleModifyCar;
import lombok.SneakyThrows;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.io.Serializable;

@Decorator
public class ModifyCarAndSayHello implements ModifyCar, Serializable {
    @Inject @Delegate
    SimpleModifyCar simpleModifyCar;

    @Override
    public void updateCar() {
        System.out.println("Hello dear owner of " + simpleModifyCar.getCar().getName() + ".");
        simpleModifyCar.updateCar();
    }
}
