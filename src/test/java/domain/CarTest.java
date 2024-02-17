package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름은 공백일 수 없다.")
    void isNameEmpty(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이하여야 한다.")
    void isUnderLengthLimit() {
        String name = "bestdriver";
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"$avage", "bony&clyde"})
    @DisplayName("자동차 이름에는 특수문자가 포함될 수 없다.")
    void isSpecialCharacter(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("자동차는 4이상의 random 값이 주어졌을 때만 전진한다.")
    void isRandomNumberOverLowerBound() {
        Car car = new Car("pobi");
        car.moveForward(3);
        assertThat(car.getDistance()).isZero();
    }
}
