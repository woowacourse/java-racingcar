package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_전진(int randomValue) {
        Car car = new Car("짱구");
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 7, 9})
    void 자동차_멈춤(int randomValue) {
        Car car = new Car("짱구");
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
