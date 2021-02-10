package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("주어진 값이 4 이하일 경우 움직이지 않음 확인")
    void carMoveRandomNumber_3(int randomNumber) {
        Car car = new Car(new Name("pobi"));
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("주어진 값이 4 이상일 경우 움직임 확인")
    void carMoveRandomNumber_4(int randomNumber) {
        Car car = new Car(new Name("pobi"));
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
