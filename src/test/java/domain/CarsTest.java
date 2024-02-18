package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    void carsNameDuplicatedTest() {
        List<String> carNames = List.of(
                "toby", "tebah", "anna", "brown", "brown"
        );
        assertThrows(IllegalArgumentException.class, () ->
                Cars.from(carNames)
        );
    }

    @Test
    void carsRaceReturnTest() {
        List<String> carNames = List.of(
                "toby", "tebah", "anna", "brown", "bro"
        );
        Cars cars = Cars.from(carNames);
        assertEquals(cars.race().carStates().size(), 5);
    }
}
