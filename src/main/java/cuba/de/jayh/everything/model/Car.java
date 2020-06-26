package cuba.de.jayh.everything.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car implements Serializable {
    private String name;
    private String imageUrl;
    private double kilometre;
    private int yearOfManufacture;
    private double price;
    private String fuelType;
    private String licencePlate;
    private String brand;
    private String model;

    @JsonIgnore
    private static ArrayList<Car> allCars = new ArrayList<Car>();


    private Car() {
    }

    //constructor
    private Car(String name, String imageUrl, double kilometre, int yearOfManufacture, double price, String fuelType, String licencePlate, String brand, String model) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.kilometre = kilometre;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.fuelType = fuelType;
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        allCars.add(this);
    }

    public static Car createCar(String name, String imageUrl, double kilometre, int yearOfManufacture, double price, String fuelType, String licencePlate, String brand, String model) {
        for (Car cars : allCars) {

            if (cars.name.equals(name) && cars.imageUrl.equals(imageUrl) && cars.kilometre == kilometre && cars.yearOfManufacture == yearOfManufacture && cars.price == price
                    && cars.fuelType.equals(fuelType) && cars.licencePlate.equals(licencePlate) && cars.brand.equals(brand) && cars.model.equals(model)) {
                System.out.println("Car already exist");
                return null;
            }
            if (cars.licencePlate.equals(licencePlate) || cars.imageUrl.equals(imageUrl)) {
                System.out.println("licencePlate already exist in list or image Url already exist in list");
                return null;
            }
            if(cars.name.equals("") || cars.imageUrl.equals("") || cars.kilometre < 0
                    || cars.yearOfManufacture < 0 || cars.price < 0 || cars.fuelType.equals("") && cars.licencePlate.equals("") && cars.brand.equals("") && cars.model.equals("")) {
                System.out.println("parameters can't be null or below zero");
                return null;
            }
        }
        return new Car(name, imageUrl, kilometre, yearOfManufacture, price, fuelType, licencePlate, brand, model);
    }

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

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }
    public static List<Car> getAllCars() {
        return Collections.unmodifiableList(allCars);
    }
    public static void setAllCars(List<Car> loadedCars) {
        allCars.addAll(loadedCars);
    }


    public static boolean deleteCar(String licencePlate) {
        for (Car car : allCars) {
            if (car.getLicencePlate().equals(licencePlate)) {
                System.out.println("in klasse Car is de auto verwijderd");
                Account.deleteFavoriteCar(licencePlate);
                return allCars.remove(car);

            }
        }
        System.out.println("auto in klasse Car kon niet verwijderd worden");
        return false;
    }

    public static Car getCarByLicencePlate(String licencePlate) {
        return allCars.stream().filter(e -> e.getLicencePlate().equals(licencePlate)).findFirst().orElse(null);
    }


    public Car updateCar(String name, String imageUrl, double kilometre, int yearOfManufacture, double price, String fuelType, String licencePlatechange, String brand, String model) {
        for (Car cars : allCars) {
            if (cars.name.equals(name) && cars.imageUrl.equals(imageUrl) && cars.kilometre == kilometre && cars.yearOfManufacture == yearOfManufacture && cars.price == price && cars.fuelType.equals(fuelType) && cars.licencePlate.equals(licencePlatechange) && cars.brand.equals(brand) && cars.model.equals(model)) {
                System.out.println("object still the same nothing has changed");
                return null;
            }
        }
        this.imageUrl = imageUrl;
        this.licencePlate = licencePlatechange;
        this.name = name;
        this.kilometre = kilometre;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.fuelType = fuelType;
        this.brand = brand;
        this.model = model;
        return (this);
    }
    public String getLicencePlate() {
        return licencePlate;
    }
    public String getModel() {
        return model;
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



    public String getBrand() {
        return brand;
    }



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

    public void setModel(String model) {
        this.model = model;
    }


}








