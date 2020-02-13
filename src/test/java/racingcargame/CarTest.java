package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @DisplayName("자동차가 4,5,6,7,8,9일 때 전진하는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int random) {
        Car car = new Car("car");
        int originalPosition = car.getCarPosition();
        car.decideGoOrStop(random);
        assertThat(car.getCarPosition()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 0,1,2,3일 때 멈춰있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int random) {
        Car car = new Car("car");
        int originalPosition = car.getCarPosition();
        car.decideGoOrStop(random);
        assertThat(car.getCarPosition()).isEqualTo(originalPosition);
    }
}
