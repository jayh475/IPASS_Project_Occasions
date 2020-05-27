package cuba.de.jayh.everything.webservices;


import cuba.de.jayh.everything.model.Car;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("cars")
public class CarsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars() {
        return Response.ok(Car.getAllCars()).status(Response.Status.OK).build();
    }

    @POST
    @RolesAllowed("admin")
    @Path("createCar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCar(@FormParam("name")String name,@FormParam("kilometre") Double kilometre,
                              @FormParam("yearOfManufacture") int yearOfManufacture,
                              @FormParam("price")double price,@FormParam("fuelType") String fuelType,
                              @FormParam("licencePlate") String licencePlate,@FormParam("brand") String brand,
                              @FormParam("model") String model,
                              @FormParam("imageUrl")String imageUrl){
        Car c =Car.createCar(name,imageUrl,
                kilometre,yearOfManufacture,
                price,fuelType,licencePlate, brand,model);
        if(c==null){
            return Response.status(404).build();
        }
        return Response.ok(c).build();




    }




}















//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//        @Path("{name}")
//        public Response getShoppingListByName(@PathParam("name") String name) {
//            Shop shop = Shop.getShop();
//            ShoppingList list = shop.getShoppingListByName(name);
//
//            if (list == null){
//                Map<String,String> messages = new HashMap();
//                messages.put("error","deze lijst bestaat niet");
//                return Response.status(Response.Status.CONFLICT).entity(messages).build();
//            }
//            return Response.ok(list).status(Response.Status.OK).build();
//
//        }
//
//        @POST
//        @Path("create")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response createShoppingList(@FormParam("name") String naam){
//            ShoppingList shoppingList = new ShoppingList(naam,new Shopper(naam));
//            if (shoppingList == null){
//                Response.status(Response.Status.CONFLICT).build();
//            }
//            return Response.ok(shoppingList).build();
//        }
//        @POST
//        @Produces(MediaType.APPLICATION_JSON)
//        @Path("AddProduct")
//        public Response AddProduct(@FormParam("product") String product, @FormParam("amount") int amount){
//            ShoppingList al = new ShoppingList("anotherList",new Shopper("temp") );
//            al.addItem(new Product(product), amount);
//
//            return Response.ok(al).build();
//
//
//
//
//        }
//







