package cuba.de.jayh.everything.webservices;

import cuba.de.jayh.everything.model.Account;
import cuba.de.jayh.everything.model.Car;
import cuba.de.jayh.everything.model.Message;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessagesResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        return Response.ok(Message.getAllMessages()).status(Response.Status.OK).build();
    }


    @POST
    @PermitAll
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(@FormParam("voornaam") String voornaam,
                                  @FormParam("achternaam") String achternaam,
                                  @FormParam("email") String email,
                                  @FormParam("onderwerp") String onderwerp,
                                  @FormParam("bericht") String bericht){
        try {
            Message message = new Message(onderwerp, bericht, voornaam, achternaam, email);
            Account.messageToAllAdmins(message);
            System.out.println("bericht is verzonden");
            return Response.ok(message).build();

        }catch(Exception e){
            System.out.println("bericht is niet verzonden");
            return Response.status(404).build();
            }
    }








}














//    @POST
//    @RolesAllowed("admin")
//    @Path("createCar")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createCar(@FormParam("name") String name, @FormParam("kilometre") Double kilometre,
//                              @FormParam("yearOfManufacture") int yearOfManufacture,
//                              @FormParam("price") double price, @FormParam("fuelType") String fuelType,
//                              @FormParam("licencePlate") String licencePlate, @FormParam("brand") String brand,
//                              @FormParam("model") String model,
//                              @FormParam("imageUrl") String imageUrl) {
//
//        Car c = Car.createCar(name, imageUrl,
//                kilometre, yearOfManufacture,
//                price, fuelType, licencePlate, brand, model);
//        if (c == null) {
//            System.out.println("auto is null of bestaat al");
//            return Response.status(404).build();
//
//        }
//        System.out.println("auto is gemaakt!");
//        return Response.ok(c).build();
//    }
