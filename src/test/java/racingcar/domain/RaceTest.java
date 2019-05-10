package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

class RaceTest {
    @Test
    void createTest() {
        Race race = new Race(Arrays.asList("A", "B", "C", "D", "E"));
        List<Car> testCars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"), new Car("D"), new Car("E"));
        Race race2 = new Race(testCars, true);
        assertThat(race).isEqualTo(race2);
    }

    @Test
    void invalidCreateTest1() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(Arrays.asList("A"));
        });
    }

    @Test
    void invalidCreateTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(Arrays.asList("A", "A"));
        });
    }

    @Test
    void getWinnersTest() {
        List<Car> testCars = Arrays.asList(new Car("T", 6), new Car("E", 3), new Car("S", 7), new Car("U", 7));
        Race race = new Race(testCars, true);
        assertThat(race.getWinners().toString()).isEqualTo(Arrays.asList("S", "U").toString());
    }
}