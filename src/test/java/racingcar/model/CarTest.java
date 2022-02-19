package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자 이상인 경우 예외처리")
    void exceededMaxCarNameLengthException() {
        String name = "qwerty";

        assertThatThrownBy(() -> new Car(new Name(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 비전진 확인")
    @ValueSource(ints = {0, 1, 2, 3})
    void notMoveTest(int number) {
        Car car = new Car(new Name("sun"));
        car.move(number);

        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 전진 확인")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int number) {
        Car car = new Car(new Name("sun"));
        car.move(number);

        assertThat(car.getPosition()).isOne();
    }
}
