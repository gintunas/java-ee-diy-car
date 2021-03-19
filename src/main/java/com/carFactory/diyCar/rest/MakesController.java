package com.carFactory.diyCar.rest;

import com.carFactory.diyCar.persistence.OriginalMakesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("addMake")
public class MakesController {
    //TODO: Add JAX methods

    @Inject
    private OriginalMakesDAO omDao;


}
