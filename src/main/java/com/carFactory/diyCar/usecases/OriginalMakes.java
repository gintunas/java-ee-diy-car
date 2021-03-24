package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.OriginalMake;
import com.carFactory.diyCar.persistence.OriginalMakesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
@Getter
@ManagedBean
public class OriginalMakes implements Serializable {
    private List<OriginalMake> allMakes;

    @Inject
    private OriginalMakesDAO omDAO;

    @PostConstruct
    public void init() {
        loadMakes();
    }

    public void loadMakes() {
        this.allMakes = this.omDAO.loadAll();
    }

    @Getter
    @Setter
    private OriginalMake omToCreate = new OriginalMake();

    @Transactional
    public String createOriginalMake() {
        this.omDAO.persist(omToCreate);
//        return "addMake";
        return "addMake?faces-redirect=true";
    }

    public List<Car> getCars(Long makeId){
        return omDAO.findOne(makeId).getCars();
    }
}
