package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningCarsFinderTest {
    @Test
    void 우승자_찾기() {
        List<Car> cars = Arrays.asList(
                            new Car("pobi", 5),
                            new Car("brown", 4),
                            new Car("jun", 3),
                            new Car("jason", 2));
        assertThat(WinningCarsFinder.findWinningCars(cars).get(0)).isEqualTo(new Car("pobi", 5));
    }
}
