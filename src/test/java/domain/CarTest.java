package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9})
    @DisplayName("최소 이동 가능 숫자 이상인 경우 전진한다.")
    public void carMoveSuccess(int number) {
        int minMoveNumber = 4;
        Car car = new Car("kong");

        assertThat(car.canMove(number, minMoveNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("최소 이동 가능 숫자 이하인 경우 전진할 수 없다.")
    public void carMoveFail(int number) {
        int minMoveNumber = 4;
        Car car = new Car("kong");

        assertThat(car.canMove(number, minMoveNumber)).isFalse();
    }
}