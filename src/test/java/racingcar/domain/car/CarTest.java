package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 생성 확인")
    void car_create() {
        Car car1 = new Car("샐리");
        assertThat(car1.getName()).isEqualTo("샐리");
        assertThat(car1.getPosition().length()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 구현")
    void car_move() {
        Car car1 = new Car("샐리");
        car1.moveByRandomNumber(5);
        assertThat(car1.getPosition().length()).isEqualTo(1);
    }
}
