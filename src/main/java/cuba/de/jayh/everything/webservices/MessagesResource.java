package cuba.de.jayh.everything.webservices;


import cuba.de.jayh.everything.model.Message;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessagesResource {

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        return Response.ok(Message.getAllMessages()).status(Response.Status.OK).build();
    }


    @POST
    @PermitAll
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(@FormParam("name") String voornaam,
                                  @FormParam("lastname") String achternaam,
                                  @FormParam("email") String email,
                                  @FormParam("topic") String onderwerp,
                                  @FormParam("question") String bericht) {
        System.out.println("bij create message" + " " + onderwerp + " " + bericht + " " + voornaam + " " + achternaam + " " + email);
        Message m = Message.createMessage(onderwerp, bericht, voornaam, achternaam, email);
        if (m == null) {
            System.out.println("bericht is niet verzonden");
            return Response.status(404).build();
        }
        System.out.println("bericht is verzonden");
        return Response.ok(m).build();
    }




}


