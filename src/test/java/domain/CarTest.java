package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void moveTest(boolean isMoved, int expected) {
        Car car = new Car("name");

        car.move(isMoved);

        Assertions.assertThat(car.getPosition()).isEqualTo(expected);
    }
}