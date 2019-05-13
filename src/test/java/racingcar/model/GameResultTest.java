package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    @Test
    void 결과문자열테스트() {
        GameResult gameResult = new GameResult();
        RacingCars racingCarsOne = new RacingCars(Arrays.asList(
                new Car("Car1", 2),
                new Car("Car2", 2),
                new Car("Car3", 2)
        ));

        RacingCars racingCarsTwo = new RacingCars(Arrays.asList(
                new Car("Car1", 3),
                new Car("Car2", 3),
                new Car("Car3", 3)
        ));
        gameResult.addResult(racingCarsOne);
        gameResult.addResult(racingCarsTwo);
        String expectedResults = "Car1 : --\n" + "Car2 : --\n" + "Car3 : --\n\n" + "Car1 : ---\n" + "Car2 : ---\n" + "Car3 : ---";
        assertThat(gameResult.getAllResults()).isEqualTo(expectedResults);
    }
}