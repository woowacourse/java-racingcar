package racingcargame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이동 확인")
    @CsvSource(value = {"3:0", "4:1", "9:1"}, delimiter = ':')
    void checkCarMode(int number, int expect) {
        Car car = new Car("green", 0);
        car.move(number);

        assertThat(car.getPosition()).isEqualTo(expect);
    }
}