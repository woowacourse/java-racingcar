package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningCarsFinderTest {
    @Test
    void 우승자_한명() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 5),
                new Car("brown", 4),
                new Car("jun", 3),
                new Car("jason", 2));
        assertThat(WinningCarsFinder.findWinningCars(cars).get(0)).isEqualTo(new Car("pobi", 5));
    }

    @Test
    void 우승자_두명() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 5),
                new Car("brown", 5),
                new Car("jun", 3),
                new Car("jason", 2));
        List<Car> winningCars = WinningCarsFinder.findWinningCars(cars);

        assertThat(winningCars.size()).isEqualTo(2);
        assertThat(WinningCarsFinder.findWinningCars(cars).get(0)).isEqualTo(new Car("pobi", 5));
        assertThat(WinningCarsFinder.findWinningCars(cars).get(1)).isEqualTo(new Car("brown", 5));
    }
}
