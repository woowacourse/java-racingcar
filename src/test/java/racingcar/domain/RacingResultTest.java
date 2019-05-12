package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("pobi", 1));
        cars.add(new Car("cony", 5));
        cars.add(new Car("whale", 10));
        cars.add(new Car("mir", 10));
    }

    @Test
    void getMaxPositionTest() {
        assertThat(RacingResult.getMaxPosition(cars)).isEqualTo(10);
    }

    @Test
    void getWinnersTest() {
        int maxPosition = 10;
        List<String> winners = new ArrayList<>();
        winners.add("whale");
        winners.add("mir");

        assertThat(RacingResult.getWinners(cars, maxPosition)).isEqualTo(winners);
    }
}
