package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerCarsTest {

    @Test
    @DisplayName("WinnerCars 우승 Car 리스트로 출력")
    void create() {
        Cars cars = new Cars(
                Collections.singletonList(
                        new Car("win")
                )
        );
        assertEquals(cars.toList(), new WinnerCars(cars).toList());
    }
}