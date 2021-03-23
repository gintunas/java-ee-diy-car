package com.carFactory.diyCar.rest;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.OriginalMakesDAO;
import com.carFactory.diyCar.rest.dto.CarDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("editCar")
public class EditCarController {
    @Inject
    private CarsDAO carsDAO;

    @Inject
    private OriginalMakesDAO omDao;

    @Path("/{id}")
    @GET
    public Response getById(@PathParam("id") final Long id) {
        Car car = carsDAO.findOne(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setName(car.getName());
        carDTO.setOriginalMake(car.getOriginalMake().getName());
        return Response.ok(carDTO).build();
    }

}
