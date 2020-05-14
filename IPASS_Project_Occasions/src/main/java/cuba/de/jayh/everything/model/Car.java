package cuba.de.jayh.everything.model;


import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    private String name;
    private String image;
    private double kilometre;
    private String  yearOfManufacture;
    private double price;
    private String fuelType;
    ArrayList<Car> cars = new ArrayList<Car>();

    public Car (String nm, String img, double km,String mfy,double pr, String ft) {
        this.name = nm;
        this.image = img;
        this.kilometre = km;
        this.yearOfManufacture = mfy;
        this.price = pr;
        this.fuelType = ft;
    }











}








