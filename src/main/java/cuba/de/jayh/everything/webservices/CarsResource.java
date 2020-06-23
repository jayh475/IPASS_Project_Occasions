package cuba.de.jayh.everything.webservices;

import cuba.de.jayh.everything.model.Car;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;


@Path("/cars")
public class CarsResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars() {
        return Response.ok(Car.getAllCars()).status(Response.Status.OK).build();
    }


    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{carsByBrand}")
    public Response getCarsByBrand(@Context SecurityContext securityContex, @PathParam("carsByBrand") String brand) {
        if (Car.getCarsByBrand(brand).isEmpty()) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("result", "auto bestaat nog niet")).build();
        }
        return Response.ok(Car.getCarsByBrand(brand)).build();
    }


}
