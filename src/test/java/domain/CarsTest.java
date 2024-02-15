package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void carsNameDuplicatedTest() {
        List<String> carNames = List.of(
                "toby", "tebah", "anna", "brown", "brown"
        );
        assertThrows(IllegalArgumentException.class, () ->
            new Cars(carNames)
        );
    }
}
