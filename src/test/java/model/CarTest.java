package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"5, 1", "3, 0", "4, 1"})
    void moveForwardTest(int randomNumber, int expectedPosition) {
        Car car = Car.from("lemon");
        car.moveForward(randomNumber);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void carNameLengthTest() {
        String wrongName = "abcdef";

        assertThatThrownBy(() -> Car.from(wrongName))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "    "})
    void carNameBlankOrNullTest(String wrongName) {
        assertThatThrownBy(() -> Car.from(wrongName))
                .isInstanceOf(IllegalStateException.class);
    }
}