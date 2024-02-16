package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("4이상일 때 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goPassable(int number) {
        // given
        Car car = Car.from("a");

        // when
        car.go(number);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4미만시 전진할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void cantGo(int number) {
        // given
        Car car = Car.from("a");

        // when
        car.go(number);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}
