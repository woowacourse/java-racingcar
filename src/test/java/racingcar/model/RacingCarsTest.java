package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {
    @Test
    void 중복된이름입력() {
        String inputCarNames = "testCar,testCar";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(inputCarNames);
        });
    }

    @Test
    void 빈문자열입력() {
        String inputCarNames = "";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(inputCarNames);
        });
    }

    @Test
    void 세개의차가_움직였을경우_포지션_문자열() {
        RacingCars racingCars = new RacingCars(Arrays.asList(
                new Car("Car1", 2),
                new Car("Car2", 2),
                new Car("Car3", 2)
        ));

        assertThat(racingCars.getCurrentPositionsOfRacingCars())
                .isEqualTo(Arrays.asList("Car1 : --", "Car2 : --", "Car3 : --"));
    }
}