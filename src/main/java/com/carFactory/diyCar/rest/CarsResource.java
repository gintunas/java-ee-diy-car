package com.carFactory.diyCar.rest;

import com.carFactory.diyCar.entities.Car;
import com.carFactory.diyCar.entities.Modification;
import com.carFactory.diyCar.entities.OriginalMake;
import com.carFactory.diyCar.persistence.CarsDAO;
import com.carFactory.diyCar.persistence.ModificationsDAO;
import com.carFactory.diyCar.persistence.OriginalMakesDAO;
import com.carFactory.diyCar.rest.dto.CarDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/cars")
public class CarsResource {
    @Inject
    private CarsDAO carsDAO;

    @Inject
    private OriginalMakesDAO omDao;

    @Inject
    private ModificationsDAO modsDao;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Car car = carsDAO.findOne(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        CarDTO carDTO = new CarDTO();
        carDTO.setName(car.getName());

        Map<String, String> omMap = new HashMap<>();
        omMap.put(car.getOriginalMake().getId().toString(), car.getOriginalMake().getName());
        carDTO.setOriginalMake(omMap);

        Map<String, String> modMap = new HashMap<>();
        car.getModifications().forEach(mod -> modMap.put(mod.getId().toString(), mod.getName()));

        carDTO.setModifications(modMap);
        return Response.ok(carDTO).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long id, CarDTO carData) {
        try {
            Car existingCar = carsDAO.findOne(id);
            if (existingCar == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingCar.setName(carData.getName());

            existingCar.setOriginalMake(getOMFromMap(carData.getOriginalMake()));

            existingCar.setModifications(getModsFromMap(carData.getModifications()));

            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    private List<Modification> getModsFromMap(Map<String, String> map) {
        List<Modification> modsList = new ArrayList<>();
        map.forEach((k, v) -> modsList.add(modsDao.findOne(Long.valueOf(k))));
        return modsList;
    }

    private OriginalMake getOMFromMap(Map<String, String> map) {
        Long omId = Long.valueOf(map.keySet().stream().findFirst().get());
        return omDao.findOne(omId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CarDTO carData) {
        Car carToCreate = new Car();
        carToCreate.setName(carData.getName());
        carToCreate.setOriginalMake(getOMFromMap(carData.getOriginalMake()));
        carToCreate.setModifications(getModsFromMap(carData.getModifications()));
        carsDAO.persist(carToCreate);
        return Response.ok().build();
    }
}