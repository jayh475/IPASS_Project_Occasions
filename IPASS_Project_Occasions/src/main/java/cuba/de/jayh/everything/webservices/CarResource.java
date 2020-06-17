package cuba.de.jayh.everything.webservices;


import cuba.de.jayh.everything.model.Account;
import cuba.de.jayh.everything.model.Car;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;


@Path("/car")
public class CarResource {




//    @GET
//    @Path("carByModel")
//    public Response getCarByModel(@PathParam("carsBymodel") String model){
//        Car m= Car.getCarsByModel(model);
//        if(m ==null) {
//            return Response.status(404).build();
//        }
//        return Response
//
//
//    }


    @POST
    @RolesAllowed("admin")
    @Path("createCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCar(@FormParam("name") String name, @FormParam("kilometre") Double kilometre,
                              @FormParam("yearOfManufacture") int yearOfManufacture,
                              @FormParam("price") double price, @FormParam("fuelType") String fuelType,
                              @FormParam("licencePlate") String licencePlate, @FormParam("brand") String brand,
                              @FormParam("model") String model,
                              @FormParam("imageUrl") String imageUrl) {

        Car c = Car.createCar(name, imageUrl,
                kilometre, yearOfManufacture,
                price, fuelType, licencePlate, brand, model);
        if (c == null) {
            System.out.println("auto is null");
            return Response.status(404).build();

        }
        System.out.println("auto is gemaakt!");
        return Response.ok(c).build();
    }


    @DELETE
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{licencePlate}")
    public Response deleteCar(@Context SecurityContext securityContext,@PathParam("licencePlate") String licencePlate) {
        securityContext.isSecure();
        if (Car.deleteCar(licencePlate)) {
            System.out.println("auto is verwijderd");
            return Response.ok().build();
        } else {
            System.out.println("Auto bestaat niet");
            return Response.status(404).build();
        }
    }

    @PATCH
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/editCar/{licencePlatefound}")
    public Response updateCar(@PathParam("licencePlatefound") String licencePlate,@FormParam("nameEdit") String name, @FormParam("kilometreEdit") Double kilometre,
                               @FormParam("yearOfManufactureEdit") int yearOfManufacture,
                               @FormParam("priceEdit") double price, @FormParam("fuelTypeEdit") String fuelType,
                                 @FormParam("brandEdit") String brand,
                               @FormParam("modelEdit") String model,
                               @FormParam("imageUrlEdit") String imageUrl, @FormParam("licencePlateChange") String licencePlateChange){
        Map<String,String> messages = new HashMap<>();
        Car car1 = Car.getCarByLicencePlate(licencePlate);
        if (car1 != null) {
            Car c1 = car1.updateCar( name,imageUrl, kilometre, yearOfManufacture,  price, fuelType,  licencePlateChange,  brand,  model);
            if (c1 != null) {
                return Response.ok(car1).build();
            }
        }
        messages.put("error","Car not found or you didnt fill in every blank");
        return Response.status(404).entity(messages).build();
    }






}








