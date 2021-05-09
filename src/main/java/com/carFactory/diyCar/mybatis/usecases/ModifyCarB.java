package com.carFactory.diyCar.mybatis.usecases;

import com.carFactory.diyCar.mybatis.dao.CarMapper;
import com.carFactory.diyCar.mybatis.dao.CarModificationMapper;
import com.carFactory.diyCar.mybatis.dao.ModificationMapper;
import com.carFactory.diyCar.mybatis.model.Car;
import com.carFactory.diyCar.mybatis.model.CarModification;
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

@Named
@ViewScoped
@Transactional
public class ModifyCarB implements Serializable {

    @Inject
    private CarMapper carMapper;

    @Inject
    ModificationMapper modMapper;

    @Inject
    CarModificationMapper carModMapper;

    @Getter
    private Car car;

    @Getter
    @Setter
    private List<Long> modificationsList = new ArrayList<>();

    @PostConstruct
    private void init() {
        System.out.println("EditCar Batis INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(requestParameters.get("carId"));
        this.car = carMapper.selectByPrimaryKey(id);
        this.car.getModifications().forEach(mod -> this.modificationsList.add(mod.getId()));
    }

    public String updateCar() {
        CarModification cm = new CarModification();
        cm.setCarId(this.car.getId());
        modificationsList.forEach(mod -> {
            cm.setModificationId(mod);
            carModMapper.insert(cm);
        });

        carMapper.updateByPrimaryKey(this.car);
        return "mybatisImpl/myCarsB?faces-redirect=true";
    }
}
