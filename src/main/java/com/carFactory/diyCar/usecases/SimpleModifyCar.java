package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.LogUnit;
import com.carFactory.diyCar.entities.Modification;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.LogDAO;
import com.carFactory.diyCar.persistence.ModificationsDAO;
import com.carFactory.diyCar.utils.clientGreeters.ClientGreeter;
import com.carFactory.diyCar.utils.concurrency.SimpleTask;
import com.carFactory.diyCar.utils.payments.PaymentProcessor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.primefaces.PrimeFaces;
import org.apache.commons.beanutils.BeanUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
        Long id = Long.parseLong(requestParameters.get("id"));
        this.car = carsDAO.findOne(id);
        this.car.getModifications().forEach(mod -> this.modificationsList.add(mod.getId()));
    }

    @Inject
    private LogDAO logDAO;

    public void completeInFuture() {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
                logDAO.persist(new LogUnit("Random log"));
                System.out.println("Added random log after 3 seconds.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private SimpleTask simpleTask = new SimpleTask();

    @SneakyThrows
    public void updateCar() {
        managedExecutorService.execute(simpleTask);
        completeInFuture();
        clientGreeter.greetClient();
        List<Modification> modifications = new ArrayList<>();
        modificationsList.forEach(l -> modifications.add(modsDao.findOne(l)));
        car.setModifications(modifications);
        Car updatedCar = carsDAO.update(car);
        if (updatedCar == null) {
            PrimeFaces.current().executeScript("PF('optimisticButton').jq.click()");
        } else FacesContext.getCurrentInstance().getExternalContext().redirect("myCars.xhtml?faces-redirect=true");

        paymentProcessor.pay();
    }

    public void addMessage(FacesMessage.Severity messageType, String summary, String detail) {
        FacesMessage message = new FacesMessage(messageType, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void refreshAndContinue() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("modifyCar.xhtml?id=" + car.getId());
        addMessage(FacesMessage.SEVERITY_INFO, "Data has been successfully updated.", "Refresh and update.");
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void overwrite() throws IOException {
        Car carInDB = carsDAO.findOne(car.getId());
        try {
            BeanUtils.copyProperties(carInDB, car);
            carsDAO.update(carInDB);
            FacesContext.getCurrentInstance().getExternalContext().redirect("myCars.xhtml");
            addMessage(FacesMessage.SEVERITY_INFO, "Data has been overwritten.", "Overwritten.");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("modifyCar.xhtml?id=" + car.getId());
            addMessage(FacesMessage.SEVERITY_INFO, "Sorry, unable to overwrite.", "Please edit again.");
        }
    }
}
