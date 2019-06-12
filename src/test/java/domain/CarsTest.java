package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void move_움직이는_경우() {
        int numCars = 3;
        Distance distance = Distance.from(0);
        Cars cars = TestCars.generateCars(numCars, distance);
        Cars movedCars = TestCars.generateCars(numCars, distance.increased());

        assertThat(cars.move(TestMoveStrategy.MOVE)).isEqualTo(movedCars);
    }

    @Test
    void move_움직이지않는_경우() {
        int numCars = 3;
        Distance distance = Distance.from(0);
        Cars cars = TestCars.generateCars(numCars, distance);
        Cars movedCars = TestCars.generateCars(numCars, distance);

        assertThat(cars.move(TestMoveStrategy.DONT_MOVE)).isEqualTo(movedCars);
    }

    @Test
    void findWinners_승자1명() {
        int distance = 10;
        Cars cars = TestCars.of(
                Arrays.asList("1", "2", "3"),
                Arrays.asList(distance, distance, distance + 1));
        Cars winners = TestCars.of(
                Arrays.asList("3"),
                Arrays.asList(distance + 1));

        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    @Test
    void findWinners_승자2명() {
        int distance = 10;
        Cars cars = TestCars.of(
                Arrays.asList("1", "2", "3"),
                Arrays.asList(distance + 1, distance, distance + 1));
        Cars winners = TestCars.of(
                Arrays.asList("1", "3"),
                Arrays.asList(distance + 1, distance + 1));

        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}