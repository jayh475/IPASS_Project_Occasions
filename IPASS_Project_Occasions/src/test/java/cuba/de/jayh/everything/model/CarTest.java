package cuba.de.jayh.everything.model;

import junit.framework.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {
    private Car c1;

    @BeforeEach
    void test() {
        c1 = Car.createCar("Volkswagen Polo 1.6 AUTOMAAT ( schade )", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6");
    }

    //create tests
    @Test
    void createCarSameLicencePlateReturnNull() {
        assertNull(c1 = Car.createCar("Volkswagen Polo 1.6 AUTOMAAT (fesdfagf", "w",
                20000, 2017, 23434, "iets", "73-MG-HJ", "Volksdefef", "Poesaeee"));
    }

    @Test
    void createCarSameEverythingReturnNull() {
        assertNull(Car.createCar("Volkswagen Polo 1.6 AUTOMAAT ( schade )", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg",
                2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6"));
    }

    @Test
    void createCarSameImageUrl() {
        assertNull(Car.createCar("x", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg",
                3, 2, 1, "x", "x", "x", "Polo 1.6"));

    }

    //    delete tests
    @Test
    void deleteCarOnlyIfLicencePlateExtistInList() {
        assertTrue(Car.deleteCar("73-MG-HJ"));
    }

    @Test
    void whenDeleteLicencePlateNotFound() {
        assertFalse(Car.deleteCar("73-MG-hi"));
    }

    //    editCar tests
    @Test
    void throwNullWhenCarObjectIsNotEdited() {
        assertNull(c1.updateCar("Volkswagen Polo 1.6 AUTOMAAT ( schade )", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6"));
    }

    @Test
    void CheckIfCarIsChangedAfterEdit() {

    }


}






