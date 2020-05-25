package cuba.de.jayh.everything.model;

import junit.framework.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class CarTest {
    private Car c1;

    @BeforeEach
    void test() {
        c1 = new Car("Volkswagen Polo 1.6 AUTOMAAT ( schade )", "", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6");

    }


}