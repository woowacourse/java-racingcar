package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("랜덤 숫자가 4 이상일 때만 자동차가 전진한다.")
    @ParameterizedTest
    @CsvSource({"5, 1", "3, 0", "4, 1"})
    void moveForwardTest(int randomNumber, int expectedPosition) {
        final Car car = Car.from("lemon");
        car.moveForward(randomNumber);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("자동차 이름이 공백 포함 5자 이하가 아닌 경우 에러가 발생한다.")
    @Test
    void carNameLengthTest() {
        final String wrongName = "abcdef";
        assertThatThrownBy(() -> Car.from(wrongName))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("자동차 이름이 공백(Blank)이거나 null인 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "    "})
    void carNameBlankOrNullTest(String wrongName) {
        assertThatThrownBy(() -> Car.from(wrongName))
                .isInstanceOf(IllegalStateException.class);
    }
}
