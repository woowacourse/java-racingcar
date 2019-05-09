package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

class RaceTest {
    @Test
    void getWinnersTest() {
        List<Car> testCars = Arrays.asList(new Car("T", 6), new Car("E", 3), new Car("S", 7), new Car("U", 7));
        Race race = new Race(testCars, true);
        assertThat(race.getWinners().toString()).isEqualTo(Arrays.asList("S", "U").toString());
    }
}