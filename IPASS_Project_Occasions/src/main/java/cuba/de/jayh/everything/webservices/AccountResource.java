//package cuba.de.jayh.everything.webservices;
//
//import cuba.de.jayh.everything.model.Account;
//import cuba.de.jayh.everything.model.Company;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/account/{accountId}")
//public class AccountResource {
//
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
//
//
//
//
//
//
