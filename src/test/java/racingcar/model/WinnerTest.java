package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    @Test
    void 우승자_한명_확인() {
        Winner winner = new Winner(new RacingCars(Arrays.asList(
                new Car("Car1", 2),
                new Car("Car2", 2),
                new Car("Car3", 3)
        )));
        assertThat(winner.getWinners())
                .isEqualTo(new RacingCars(Arrays.asList(new Car("Car3", 3))));
    }

    @Test
    void 우승자_전부_확인() {
        Winner winner = new Winner(new RacingCars(Arrays.asList(
                new Car("Car1", 2),
                new Car("Car2", 2),
                new Car("Car3", 2)
        )));
        assertThat(winner.getWinners())
                .isEqualTo(new RacingCars(Arrays.asList(
                        new Car("Car1", 2),
                        new Car("Car2", 2),
                        new Car("Car3", 2)
                )));
    }
}