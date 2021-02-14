package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("Car 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void checkLengthTest(String name) {
        assertThatCode(() -> Car.createByName(name))
            .doesNotThrowAnyException();
    }

    @DisplayName("Car 이름이 Null인 경우 에러 발생")
    @Test
    void checkNullExceptionTest() {
        assertThatThrownBy(() -> Car.createByName(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Car 이름 길이가 1이상 5이하가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "123456"})
    void checkLengthExceptionTest(String name) {
        assertThatThrownBy(() -> Car.createByName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 4보다 작은 경우 Car 정지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void carStop(int move) {
        Car car = Car.createByName("test");
        car.tryMove(move);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("입력 값이 4보다 작은 경우 Car 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 9, 10})
    void carMove(int move) {
        Car car = Car.createByName("test");
        car.tryMove(move);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
