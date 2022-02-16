package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("move 의 파라미터로 4 이상의 값이 들어오면, 차량의 Position 이 1 증가한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move(int input) {
        Car car = Car.of("car", 0);
        assertThat(car.move(input)).isTrue();
    }

    @DisplayName("move 의 파라미터로 3 이하의 값이 들어오면, 차량의 Position 이 증가하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void doNotMove(int input) {
        Car car = Car.of("car", 0);
        assertThat(car.move(input)).isFalse();
    }
}
