package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars(){
        assertDoesNotThrow(()->new Cars("pobi,crong,honux"));
    }
}