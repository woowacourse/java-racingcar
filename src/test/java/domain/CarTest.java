package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "gray1234"})
    @DisplayName("1 ~ 5 크기의 이름이 아닌 경우 예외가 발생한다.")
    public void carCreateFail(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9})
    @DisplayName("최소 이동 가능 숫자 이상인 경우 전진한다.")
    public void carMoveSuccess(int number) {
        Car car = new Car("kong");

        assertThat(car.canMove(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("최소 이동 가능 숫자 이하인 경우 전진할 수 없다.")
    public void carMoveFail(int number) {
        Car car = new Car("kong");

        assertThat(car.canMove(number)).isFalse();
    }
}
