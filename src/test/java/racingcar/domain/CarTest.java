package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void createCar() {
        assertThat(car).extracting("name")
                .isEqualTo("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "banana"})
    @DisplayName("자동차의 이름이 공백이거나 5글자를 초과하면 예외가 발생한다.")
    void invalidName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0"})
    @DisplayName("random 값이 4 이상일 경우 자동차는 이동하고, random 값이 4 미만인 경우 자동차는 이동하지 않는다.")
    void moveTest(int randomNumber, int expected) {
        car.move(randomNumber);

        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
