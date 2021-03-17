package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.OriginalMake;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.OriginalMakesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
@Getter
@Setter
public class Cars implements Serializable {

    @Inject
    private CarsDAO carsDAO;

    @Inject
    private OriginalMakesDAO omDao;

    private Car carToCreate = new Car();

    private long omID;

    private OriginalMake originalMake;

    public List<Car> getAllCars(){
        return this.carsDAO.loadAll();
    }

    @Transactional
    public String createCar() {
        carToCreate.setOriginalMake(this.omDao.findOne(omID));
        this.carsDAO.persist(carToCreate);
        return "index?faces-redirect=true";
//        return "success";
    }
}
