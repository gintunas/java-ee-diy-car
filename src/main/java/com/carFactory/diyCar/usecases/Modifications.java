package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.Modification;
import com.carFactory.diyCar.entities.OriginalMake;
import com.carFactory.diyCar.persistence.ModificationsDAO;
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
public class Modifications implements Serializable {
    private List<Modification> allMods;

    @Inject
    private ModificationsDAO modDao;

    @PostConstruct
    public void init() {
        loadMods();
    }

    public void loadMods() {
        this.allMods = this.modDao.loadAll();
    }

    @Setter
    private Modification modToCreate = new Modification();

    @Transactional
    public String createMod() {
        this.modDao.persist(modToCreate);
        return "index?faces-redirect=true";
    }

}
