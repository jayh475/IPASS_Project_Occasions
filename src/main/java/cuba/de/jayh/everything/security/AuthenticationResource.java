package cuba.de.jayh.everything.security;

import cuba.de.jayh.everything.model.Account;
import cuba.de.jayh.everything.response.TokenResponse;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Key;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {
        try {
            String role = Account.validateLogin(username, password);


            if (role == null) {
                return Response.status(Response.Status.CONFLICT).entity("user not found").build();
            }

            String token = createToken(username, role);
//            SimpleEntry<String,String> JWT = new SimpleEntry<>("JWT",token);
            TokenResponse tr = new TokenResponse();
            tr.setToken(token);
            tr.setMessage(username); // zodat ik mijn naam kan printen bij de admin scherm

            System.out.println("login is gelukt");
            return Response.ok(tr).build();
        } catch (JwtException | IllegalArgumentException e) {
            TokenResponse tr = new TokenResponse();
            tr.setMessage("JwtException//illegalargumentException" + e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(tr).build();
        }
    }


    @POST
    @Path("/register")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response registerUser(@Context SecurityContext securityContext, @FormParam("checkbox") String checkbox, @FormParam("password") String password,
                                 @FormParam("username") String username) {
        System.out.println("registeren");

        String role = "user";

        try {
            Account account= new Account(username, password);

            System.out.println(securityContext.toString());
            try {
                if (securityContext.isUserInRole("admin") && checkbox.equals("on")) {
                    account.setAdmin();
                    role = "admin";
                    System.out.println("account wordt gemaakt als admin");
                }
            }catch( Exception e){
                System.out.println("normale user wordt aangemaakt");


            }

            String token = createToken(username, role);
            TokenResponse tr = new TokenResponse();
            tr.setToken(token);
            System.out.println("account is aangemaakt");


            return Response.ok(tr).build();


        } catch (Exception e) {
            TokenResponse tr = new TokenResponse();
            tr.setMessage("Account bestaat al");
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(tr).build();

        }


    }














    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()

                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

}



