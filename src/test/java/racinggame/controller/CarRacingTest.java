package racinggame.controller;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {
    @Test
    void 객체를_제대로_생성하는지_테스트() {
        /* Given */
        final List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"));
        /* Then */
        assertThat(new CarRacing(cars, 3)).isEqualTo(new CarRacing(cars, 3));
    }
}