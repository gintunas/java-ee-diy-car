package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.Modification;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.ModificationsDAO;
import com.carFactory.diyCar.utils.clientGreeters.ClientGreeter;
import com.carFactory.diyCar.utils.concurrency.SimpleTask;
import com.carFactory.diyCar.utils.payments.PaymentProcessor;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
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
public class SimpleModifyCar implements Serializable, ModifyCar {
    private Car car;

    @Resource
    private ManagedExecutorService managedExecutorService;

    @Inject
    private CarsDAO carsDAO;

    @Inject
    private ModificationsDAO modsDao;

    @Inject
    private PaymentProcessor paymentProcessor;

    @Inject
    private ClientGreeter clientGreeter;

    private List<Long> modificationsList = new ArrayList<>();

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(requestParameters.get("carId"));
        this.car = carsDAO.findOne(id);
        this.car.getModifications().forEach(mod -> this.modificationsList.add(mod.getId()));
    }

    private SimpleTask simpleTask = new SimpleTask();

    public String updateCar() {
        managedExecutorService.execute(simpleTask);
        clientGreeter.greetClient();
        paymentProcessor.pay();
        List<Modification> modifications = new ArrayList<>();
        modificationsList.forEach(l -> modifications.add(modsDao.findOne(l)));
        car.setModifications(modifications);
        carsDAO.update(car);
        return "myCars?faces-redirect=true";
    }
}
