package cuba.de.jayh.everything.model;


import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    private String name;
    private String imageUrl;
    private double kilometre;
    private String  yearOfManufacture;
    private double price;
    private String fuelType;
    private String licensePlate;
    private String brand;
    private String model;
    static ArrayList<Car> cars = new ArrayList<Car>();

    //constructor
    public Car(String name, String imageUrl, double kilometre,String yearOfManufacture,double price, String fuelType, String licensePlate, String brand, String model) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.kilometre = kilometre;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.fuelType = fuelType;
        this.licensePlate = licensePlate;
        this.brand =brand;
        this.model =model;
        cars.add(this);
    }


    // getters
    public String getName() {
        return name;
    }
    public String getImage() {
        return imageUrl;
    }
    public double getKilometre() {
        return kilometre;
    }
    public String getYearOfManufacture() {
        return yearOfManufacture;
    }
    public double getPrice() {
        return price;
    }
    public String getFuelType() {
        return fuelType;
    }
    public  ArrayList<Car> getCars() {
        return cars;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getBrand() {
        return brand;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setKilometre(double kilometre) {
        this.kilometre = kilometre;
    }
    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //equals
    public boolean equals(Object obj) {
        boolean sameObject = false;

        if (obj instanceof Car) {
            Car otherCar = (Car) obj; //cast
            if (this.licensePlate.equals(otherCar.licensePlate) ){
                sameObject = true;
            }
        }
        return sameObject;
    }





}








