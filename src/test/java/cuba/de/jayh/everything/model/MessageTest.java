package cuba.de.jayh.everything.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {



    @BeforeEach
    void test() {
        Message message = new Message("auto","waarom is deze auto er niet meer?",
                "jayh","de cuba","jayh.decuba@gmail.com" );




    }


    @Test
    void ifMessageExistThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Message("auto","waarom is deze auto er niet meer?",
                    "jayh","de cuba","jayh.decuba@gmail.com" );
        });
        String expectedMessage = "Account bestaat al";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void messageVariabelCantBeNull() {


    }


}