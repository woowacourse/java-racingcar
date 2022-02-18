package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 전진 조건값 이상일 경우 한칸 전진")
    void carShouldMove(int input) {
        Car car = new Car("woo");

        car.move(input);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤값이 전진 조건값 미만일 경우 전진하지 않음")
    void carShouldNotMove(int input) {
        Car car = new Car("woo");

        car.move(input);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("주어진 전진횟수와 동일한 전진횟수를 가지는 경우 true 반환")
    void trueIfSame() {
        Car car = new Car("woo", 3);

        assertThat(car.isSamePosition(3)).isTrue();
    }

    @Test
    @DisplayName("주어진 전진횟수와 동일하지 않는 전진횟수를 가지는 경우 false 반환")
    void falseIfNotSame() {
        Car car = new Car("woo", 1);

        assertThat(car.isSamePosition(3)).isFalse();
    }

}