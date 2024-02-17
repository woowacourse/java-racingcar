package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0"})
    @DisplayName("random 값이 4 이상일 경우 자동차는 이동하고, random 값이 4 미만인 경우 자동차는 이동하지 않는다.")
    void moveTest(int randomNumber, int expected) {
        Car car = new Car("pobi");
        car.move(randomNumber);

        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
