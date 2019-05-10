package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningCarsFinderTest {
    @Test
    void 우승자_찾기() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("brown", 4));
        cars.add(new Car("jun", 3));
        cars.add(new Car("jason", 2));
        assertThat(WinningCarsFinder.findWinningCars(cars).get(0)).isEqualTo(new Car("pobi", 5));
    }
}
