package racingcar.model;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.utils.generator.MovableNumberGenerator;
import racingcar.utils.generator.NumberGenerator;

class CarsTest {
    private Car car1, car2, car3;
    private Cars cars;
    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();

    @BeforeEach
    void initialize() {
        car1 = new Car("pobi");
        car2 = new Car("crong");
        car3 = new Car("honux");
        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    void 단독_우승자() {
        car1.forward(movableNumberGenerator);
        Assertions.assertThat(cars.findWinnerNames()).containsExactly("pobi");
    }

    @Test
    void 공동_우승자() {
        car1.forward(movableNumberGenerator);
        car2.forward(movableNumberGenerator);
        Assertions.assertThat(cars.findWinnerNames()).containsExactly("pobi", "crong");
    }
}