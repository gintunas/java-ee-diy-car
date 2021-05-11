package com.carFactory.diyCar.persistence;


import com.carFactory.diyCar.entities.Modification;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ModificationsDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(Modification m) {
        this.em.persist(m);
    }

    public Modification findOne(Long id) {
        return this.em.find(Modification.class, id);
    }

    public Modification update(Modification m) {
        return this.em.merge(m);
    }

    public List<Modification> loadAll() {
        return this.em.createNamedQuery("Modification.findAll", Modification.class).getResultList();
    }
}
