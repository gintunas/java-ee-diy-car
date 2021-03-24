package com.carFactory.diyCar.mybatis.usecases;

import com.carFactory.diyCar.mybatis.dao.CarMapper;
import com.carFactory.diyCar.mybatis.dao.OriginalMakeMapper;
import com.carFactory.diyCar.mybatis.model.Car;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CarsB {
    @Inject
    private CarMapper carMapper;

    @Inject
    private OriginalMakeMapper omMapper;

    public List<Car> getAllCars() {
        return carMapper.selectAll();
    }

    @Getter
    @Setter
    private Car carToCreate = new Car();

    @Getter
    @Setter
    private Long omID;

    @Transactional
    public String createCar() {
        carToCreate.setOriginalmakeId(omID);
        carMapper.insert(carToCreate);
        System.out.println("NU BLET");
        return "myCarsB?faces-redirect=true";
    }
}
