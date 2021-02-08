package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 생성 확인")
    void car_create() {
        Car car1 = Car.enrollWithName("샐리");
        assertThat(car1.getName()).isEqualTo("샐리");
        assertThat(car1.getPosition().length()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 구현")
    void car_move() {
        Car car1 = Car.enrollWithName("샐리");
        car1.fillUpGas(4);
        car1.forward();
        assertThat(car1.getPosition().length()).isEqualTo(1);

        car1.fillUpGas(3);
        car1.forward();
        assertThat(car1.getPosition().length()).isEqualTo(1);
    }
}
