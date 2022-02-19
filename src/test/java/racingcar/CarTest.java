package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = 4)
    void 자동차_전진_확인(int value) {
        Car car = new Car("qwer");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 3)
    void 자동차_전진안함_확인(int value) {
        Car car = new Car("qwer");
        car.move(value);
        assertThat(car.getPosition()).isZero();
    }
}
