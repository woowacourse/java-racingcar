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
        Car winnerCar = new Car("win");
        winnerCar.move(5);
        Car loserCar = new Car("lose");
        Car anotherLoser = new Car("lost");
        Cars cars = new Cars(
                Arrays.asList(
                        winnerCar,
                        loserCar,
                        anotherLoser
                )
        );
        Cars comparingCars = new Cars(
                Collections.singletonList(
                        winnerCar
                )
        );
        assertEquals(new WinnerCars(cars).toList(), comparingCars.toList());
    }
}