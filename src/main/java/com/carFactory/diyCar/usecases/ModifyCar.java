package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.Modification;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.ModificationsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
@Transactional
public class ModifyCar implements Serializable {
    private Car car;

    @Inject
    private CarsDAO carsDAO;

    @Inject
    private ModificationsDAO modsDao;

    private List<Long> modificationsList = new ArrayList<>();

    @PostConstruct
    private void init() {
        System.out.println("EditCar INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(requestParameters.get("carId"));
        this.car = carsDAO.findOne(id);
        this.car.getModifications().forEach(mod -> this.modificationsList.add(mod.getId()));
    }

    public void updateCar() {
        List<Modification> modifications = new ArrayList<>();
        modificationsList.forEach(l -> modifications.add(modsDao.findOne(l)));
        car.setModifications(modifications);
        carsDAO.update(car);
    }
}
