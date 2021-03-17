package com.carFactory.diyCar.persistence;

import com.carFactory.diyCar.entities.OriginalMake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OriginalMakesDAO {
    @Inject
    private EntityManager em;

    public void persist(OriginalMake om) {
        this.em.persist(om);
    }

    public OriginalMake findOne(Long id) {
        return this.em.find(OriginalMake.class, id);
    }

    public OriginalMake update(OriginalMake om) {
        return this.em.merge(om);
    }

    public List<OriginalMake> loadAll() {
        return this.em.createNamedQuery("OriginalMake.findAll", OriginalMake.class).getResultList();
    }
}
