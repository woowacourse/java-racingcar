package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("자동차 이름이 비어있는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"''", "' '", "null"}, nullValues = {"null"})
    void creationTest_whenNameLengthIsBlank_throwException(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5자를 넘어가는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"123456", "123 45", "thisIsNull"})
    void creationTest_whenNameLengthIsOver5_throwException(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 움직일 수 있다.")
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void moveTest(boolean isMoved, int expected) {
        // given
        Car car = new Car("name");

        // when
        car.move(isMoved);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(expected);
    }
}