package cuba.de.jayh.everything.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car implements Serializable  {
    private static Car my_inventory = new Car();
    public static Car getMy_inventory() {return my_inventory;}
    public static void setInventory(Car car){my_inventory= car;}


    private String name;
    private String imageUrl;
    private double kilometre;
    private int  yearOfManufacture;
    private double price;
    private String fuelType;
    private String licencePlate;
    private String brand;
    private String model;

    @JsonIgnore
//    private static List<Car> allCars = new ArrayList<>();
    static ArrayList<Car> allCars = new ArrayList<Car>();



    private Car(){


    }

    //constructor
    private Car(String name, String imageUrl, double kilometre,int yearOfManufacture,double price, String fuelType, String licencePlate, String brand, String model) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.kilometre = kilometre;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.fuelType = fuelType;
        this.licencePlate = licencePlate;
        this.brand =brand;
        this.model =model;
        allCars.add(this);
    }

    public static Car createCar(String name, String imageUrl, double kilometre,int yearOfManufacture,double price, String fuelType, String licencePlate, String brand, String model) {
        for (Car cars : allCars) {
            if (cars.name.equals(name) && cars.imageUrl.equals(imageUrl) && cars.kilometre == kilometre && cars.yearOfManufacture == yearOfManufacture && cars.price == price && cars.fuelType.equals(fuelType) && cars.licencePlate.equals(licencePlate) && cars.brand.equals(brand) && cars.model.equals(model)) {
                System.out.println("auto bestaat al");
                return null;

            }
            if(cars.licencePlate.equals(licencePlate)){
                return null;
            }
        }
        return new Car(name, imageUrl, kilometre, yearOfManufacture, price, fuelType, licencePlate, brand, model);
    }



    // getters
    public String getName() {
        return name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public double getKilometre() {
        return kilometre;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public double getPrice() {
        return price;
    }
    public String getFuelType() {
        return fuelType;
    }
    public static List<Car> getAllCars() {
        return Collections.unmodifiableList(allCars);
    }
    public String getLicencePlate() {
        return licencePlate;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel(){return model;}

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.imageUrl = image;
    }
    public void setKilometre(double kilometre) {
        this.kilometre = kilometre;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model){this.model = model;}



@JsonIgnore
    public static ArrayList<Car> getCarsByBrand(String brand) {
        ArrayList<Car> theBrandList = new ArrayList<>();
        for (Car car : allCars) {
            if (car.brand.equals(brand)) {
                theBrandList.add(car);
            }
        }
        return theBrandList;
    }

//
//    public static Car getCarsByModel(String model){
//
//    }





}








