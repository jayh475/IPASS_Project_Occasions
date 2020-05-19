package cuba.de.jayh.everything.model;

import junit.framework.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class CarTest {
    private Car c1;

    @BeforeEach
    void test(){
        c1 = new Car("Volkswagen Polo 1.6 AUTOMAAT ( schade )" , "", 2000, 2016,1800,"diesel","73-MG-HJ","Volkswagen","Polo 1.6" );

    }



    @Test
    void getName() {
        Assert.assertEquals("Volkswagen Polo 1.6 AUTOMAAT ( schade )",c1.getName());
    }

    @Test
    void getImage() {
    }

    @Test
    void getKilometre() {
    }

    @Test
    void getYearOfManufacture() {

    }

    @Test
    void getPrice() {
    }

    @Test
    void getFuelType() {
    }

    @Test
    void getCars() {
    }

    @Test
    void getLicensePlate() {
    }

    @Test
    void getBrand() {
    }

    @Test
    void setName() {
    }

    @Test
    void setImage() {
    }

    @Test
    void setKilometre() {
    }

    @Test
    void setYearOfManufacture() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void setFuelType() {
    }

    @Test
    void setLicensePlate() {
    }

    @Test
    void setBrand() {
    }

    @Test
    void testEquals() {
    }
}