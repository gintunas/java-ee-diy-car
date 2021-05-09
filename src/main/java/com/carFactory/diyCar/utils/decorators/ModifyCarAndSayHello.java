package com.carFactory.diyCar.utils.decorators;

import com.carFactory.diyCar.usecases.ModifyCar;
import com.carFactory.diyCar.usecases.SimpleModifyCar;
import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import java.io.Serializable;

@Decorator
public class ModifyCarAndSayHello implements ModifyCar, Serializable {
    @Inject @Delegate
    SimpleModifyCar simpleModifyCar;

    @SneakyThrows
    @Override
    public String updateCar() {
        System.out.println("Hello friends.");

        return simpleModifyCar.updateCar();
    }
}
