package racingcar;

import racingcar.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자이하여야하며 빈칸은 허용하지 않는다.")
    @ValueSource(strings = {" ", "abcdefg", "  "})
    void createCarExceptionTest(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));
        assertThat(e.getMessage()).isEqualTo(Car.CAR_NAME_INVALID);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 3이하면 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void stopCarTest(int number) {
        Car car = new Car("pika");
        car.movePosition(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4이상이면 움직인다.")
    @ValueSource(ints = {4, 6, 9})
    void moveCarTest(int number) {
        Car car = new Car("pika");
        car.movePosition(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
