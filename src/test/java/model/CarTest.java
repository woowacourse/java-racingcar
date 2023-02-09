package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Random Number가 4 이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    void moveTrue(int input) {
        Car car = new Car("True");

        assertThat(car.move(input)).isTrue();
    }

    @DisplayName("Random Number가 3 이하인 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void moveFalse(int input) {
        Car car = new Car("False");

        assertThat(car.move(input)).isFalse();
    }
}
