package racingcargame.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    Car car = new Car(new Name("a"));

    @ParameterizedTest
    @DisplayName("자동차가 4,5,6,7,8,9일 때 전진하는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int num) {
        int originalPosition = car.getPosition().getNumber();
        car.decideGoOrStop(num);
        assertThat(car.getPosition().getNumber()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 0,1,2,3일 때 멈춰있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int num) {
        int originalPosition = car.getPosition().getNumber();
        car.decideGoOrStop(num);
        assertThat(car.getPosition().getNumber()).isEqualTo(originalPosition);
    }
}
