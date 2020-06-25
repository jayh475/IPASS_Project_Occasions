package cuba.de.jayh.everything.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    public Account a1;

    @BeforeEach
    void test() {
        a1 = new Account("jayh475", "123");

    }

    @Test
    void ifAccountExistThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    new Account("jayh475", "123");
                });
        String expectedMessage = "Account bestaat al";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    }





