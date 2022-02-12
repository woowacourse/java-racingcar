package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5})
    @DisplayName("자동차 이동시 랜덤값이 4이상인 경우 position변화 테스트")
    public void drive_forward_value(int value) {
        Car car = new Car("Rookie");
        car.drive(value);

        assertThat(1).isEqualTo(car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3})
    @DisplayName("자동차 이동시 랜덤값이 3이하인 경우 position변화 테스트")
    public void drive_stop_value(int value) {
        Car car = new Car("is2js");
        car.drive(value);

        assertThat(0).isEqualTo(car.getPosition());
    }
}
