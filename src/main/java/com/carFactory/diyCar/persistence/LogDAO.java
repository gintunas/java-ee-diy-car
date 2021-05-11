package com.carFactory.diyCar.persistence;

import com.carFactory.diyCar.entities.LogUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class LogDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void persist(LogUnit logUnit) {
        this.em.persist(logUnit);
    }
}
