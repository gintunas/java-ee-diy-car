package com.carFactory.diyCar.persistence;

import com.carFactory.diyCar.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CarsDAO {

    @Inject
    private EntityManager em;

    public void persist(Car car) {
        this.em.persist(car);
    }

    @Transactional
    public Car findOne(Long id) {
        return this.em.find(Car.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    }

    public Car update(Car car) {
        return this.em.merge(car);
    }

    public List<Car> loadAll() {
        return this.em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }
}
