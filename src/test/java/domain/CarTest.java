package domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름의 길이가 1보다 작거나 5보다 큰 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void throwExceptionWhenLengthOfCarNameOutOfRange(String input) {
        assertThatThrownBy(() ->  new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이가 1이상 5이하이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createCarWhenLengthOfCarNameIsValidate(String input) {
        assertDoesNotThrow(() -> new Car(input));
    }

    @DisplayName("랜덤 값이 3보다 큰 경우 전진한다.")
    @Test
    public void moveWhenRandomNumberIsOverThree() {
        //given
        Car car = new Car("123");

        //when
        car.move(4);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3이하인 경우 전진하지 않는다.")
    @Test
    public void moveWhenRandomNumberIsUnderThree() {
        //given
        Car car = new Car("123");

        //when
        car.move(3);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}