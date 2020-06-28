package cuba.de.jayh.everything.model;

public class CarFilter {
    private String brand;
    private String fuelType;
    private int yearOfManufactureFrom;
    private int YearOfManufacturetill;
    private int kmFrom;
    private int kmTill;
    private int priceFrom;
    private int priceTill;


    public CarFilter(String brand, String fuelType, int yearOfManufactureFrom, int yearOfManufacturetill, int kmFrom, int kmTill, int priceFrom, int priceTill) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.yearOfManufactureFrom = yearOfManufactureFrom;
        YearOfManufacturetill = yearOfManufacturetill;
        this.kmFrom = kmFrom;
        this.kmTill = kmTill;
        this.priceFrom = priceFrom;
        this.priceTill = priceTill;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getYearOfManufactureFrom() {
        return yearOfManufactureFrom;
    }

    public void setYearOfManufactureFrom(int yearOfManufactureFrom) {
        this.yearOfManufactureFrom = yearOfManufactureFrom;
    }

    public int getYearOfManufacturetill() {
        return YearOfManufacturetill;
    }

    public void setYearOfManufacturetill(int yearOfManufacturetill) {
        YearOfManufacturetill = yearOfManufacturetill;
    }

    public double getKmFrom() {
        return kmFrom;
    }

    public void setKmFrom(int kmFrom) {
        this.kmFrom = kmFrom;
    }

    public double getKmTill() {
        return kmTill;
    }

    public void setKmTill(int kmTill) {
        this.kmTill = kmTill;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTill() {
        return priceTill;
    }

    public void setPriceTill(int priceTill) {
        this.priceTill = priceTill;
    }





}
