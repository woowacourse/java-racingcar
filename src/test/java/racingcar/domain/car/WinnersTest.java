package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("WinnerCars 우승 Car 리스트로 출력")
    void create() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("java")
        );
        assertEquals(cars, new Winners(cars).toList());
    }
}