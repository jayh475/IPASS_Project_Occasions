package cuba.de.jayh.everything.webservices;


import cuba.de.jayh.everything.model.Car;
import cuba.de.jayh.everything.model.CarFilter;

import javax.annotation.security.PermitAll;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


@Path("/cars")
public class CarsResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars() {
        List<Car> cars = Car.getAllCars();


        return Response.ok(cars).status(Response.Status.OK).build();
    }


    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Path("byValue")
    public Response getCarsByValue(@FormParam("brand") String brand,
                                   @FormParam("yearOfManufactureFrom") int yearOfManufactureFrom,
                                   @FormParam("yearOfManufactureTill") int yearOfManufactureTill,
                                   @FormParam("fuelType") String fuelType,
                                   @FormParam("priceFrom") int priceFrom,@FormParam("priceTill") int priceTill,
                                   @FormParam("kmFrom") int kmFrom, @FormParam("kmTill") int kmTill) {


        CarFilter carFilter = new CarFilter(brand,fuelType,yearOfManufactureFrom,
                yearOfManufactureTill,kmFrom,kmTill,priceFrom,priceTill);
        Car.filterCars(carFilter);


        if (Car.filterCars(carFilter).isEmpty()) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("result", "auto bestaat nog niet")).build();
        }
        return Response.ok(Car.filterCars(carFilter)).build();

    }
}


