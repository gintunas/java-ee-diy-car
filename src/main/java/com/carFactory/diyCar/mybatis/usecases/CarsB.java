package com.carFactory.diyCar.mybatis.usecases;

import com.carFactory.diyCar.mybatis.dao.CarMapper;
import com.carFactory.diyCar.mybatis.dao.OriginalMakeMapper;
import com.carFactory.diyCar.mybatis.model.Car;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarsB implements Serializable {
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
        return "myBatisImpl/myCarsB?faces-redirect=true";
    }
}
