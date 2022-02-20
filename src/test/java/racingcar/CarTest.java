package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 자동차의_이름이_6자_이상인_경우_예외처리() {
        assertThatThrownBy(() -> {
            new Car("asdbds");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_빈_믄자열인_경우_예외처리() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
