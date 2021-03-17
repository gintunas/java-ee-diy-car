package com.carFactory.diyCar.persistence;

import com.carFactory.diyCar.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarsDAO {

    @Inject
    private EntityManager em;

    public void persist(Car car) {
        this.em.persist(car);
    }

    public Car findOne(Long id) {
        return this.em.find(Car.class, id);
    }

    public Car update(Car car) {
        return this.em.merge(car);
    }

    public List<Car> loadAll() {
        return this.em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }
}
