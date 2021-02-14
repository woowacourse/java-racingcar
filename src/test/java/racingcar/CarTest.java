package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자이하여야하며 빈칸은 허용하지 않는다.")
    @ValueSource(strings = {" ", "abcdefg", "  "})
    void createCarExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Car.CAR_NAME_LENGTH_INVALID);
    }

    @ParameterizedTest
    @DisplayName("값에 따라 자동차가 움직이거나 움직이지 않는다.")
    @CsvSource(value = {"0:0", "1:0", "2:0", "4:1", "7:1", "9:1"}, delimiter = ':')
    void moveCarTest(String value, String position) {
        Car car = new Car("pika");
        car.movePosition(Integer.parseInt(value));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(position));
    }
}
