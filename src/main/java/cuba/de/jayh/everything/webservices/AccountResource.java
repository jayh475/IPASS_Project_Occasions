package cuba.de.jayh.everything.webservices;//package cuba.de.jayh.everything.webservices;
//
//import cuba.de.jayh.everything.model.Account;
//import cuba.de.jayh.everything.model.Company;


import cuba.de.jayh.everything.model.Account;
import cuba.de.jayh.everything.model.Car;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@Path("/account")
public class AccountResource {


    @GET
    @Path("myFavoriteCars")
    @RolesAllowed({"admin", "user"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getfavoriteCars(@Context SecurityContext securityContext) {
        Account account = Account.getAccountByname(securityContext.getUserPrincipal().getName());
        if (account == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(new AbstractMap.SimpleEntry<>("getFavoriteCars", "er is niet ingelogd")).build();
        }
        return Response.ok(account.getFavoriteCars()).status(Response.Status.OK).build();
    }


    @POST
    @RolesAllowed({"admin", "user"})
    @Path("/addFavoriteCar/{licencePlate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFavoriteCar(@Context SecurityContext securityContext, @PathParam("licencePlate") String licencePlate) {


        Account account = Account.getAccountByname(securityContext.getUserPrincipal().getName());
        if (account == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new AbstractMap.SimpleEntry<String, String>("result", "Er is niet ingelogd")).build();
        }
        Car car = Car.getCarByLicencePlate(licencePlate);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(new AbstractMap.SimpleEntry<String, String>("result", "auto is niet gevonden")).build();
        }
        account.addFavoriteCar(car);
        return Response.ok(account.getFavoriteCars()).build();
    }


    @DELETE
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteFavoriteCar/{licencePlate}")
    public Response deleteFavoriteCar(@Context SecurityContext securityContext, @PathParam("licencePlate") String licencePlate) {
        securityContext.isSecure();
        if (Account.deleteFavoriteCar(licencePlate)) {
            System.out.println("auto is verwijderd uit favorieten");
            return Response.ok().build();
        } else {
            System.out.println("Auto bestaat niet");
            return Response.status(404).build();
        }
    }
}










//    @GET
//    @Path("{username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAccount(@Context SecurityContext securityContext, @PathParam("username") String name) {
//        Account account = Account.getAccountByname(name);
//        if (account == null) {
//            Map<String, String> message = new HashMap<>();
//            message.put("error", "Account does not exist");
//            message.put("requestedUsername", name);
//            return Response.status(409).entity(message).build();
//        }
//        return Response.ok(account).build();
//    }

//
//    @GET
//    @Path("username")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUsername(){
//
//    }



//}



//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response getAccount(@PathParam("accountId") String accountId) {
//            Account account = Company.getCompany().getAccount(accountId);
//
//            if (account != null) {
//                return Response.ok(account).build();
//            } else {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//        }
//    }






