package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차가")
public class CarTest {

    @DisplayName("전진하는 경우")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    void moveTrue(int input) {
        Car car = new Car("move");
        car.move(input);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("전진하지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void moveFalse(int input) {
        Car car = new Car("stay");
        car.move(input);

        assertThat(car.getDistance()).isEqualTo(0);
    }
}
