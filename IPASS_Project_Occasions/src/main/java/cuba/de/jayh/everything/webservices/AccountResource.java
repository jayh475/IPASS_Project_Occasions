package cuba.de.jayh.everything.webservices;//package cuba.de.jayh.everything.webservices;
//
//import cuba.de.jayh.everything.model.Account;
//import cuba.de.jayh.everything.model.Company;

import cuba.de.jayh.everything.model.Account;


import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/account")
public class AccountResource {


    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("username")String name ){
        Account account = Account.getAccountByname(name);
        if(account == null ){
            Map<String,String> message = new HashMap<>();
            message.put("error", "Account does not exist");
            message.put("requestedUsername", name);
            return Response.status(409).entity(message).build();
        }
            return Response.ok(account).build();
        }

//    @PUT
//    @RolesAllowed("user")
//    @Path("{username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateAccount(@PathParam("username") String name ){
//        Account replaced =Accoun
//
//    }
//





}


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



