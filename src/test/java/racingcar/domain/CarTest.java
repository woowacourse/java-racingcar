package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    @DisplayName("자동차 생성 확인")
    void car_create() {
        final Car car1 = new Car("샐리");
        assertThat(car1.getName().getName()).isEqualTo("샐리");
        assertTrue(car1.getPosition().isSameThan(0));
    }

    @Test
    @DisplayName("자동차 전진 구현")
    void car_move() {
        final Car car1 = new Car("샐리");
        car1.moveByRandomNumber(5);
        assertTrue(car1.getPosition().isSameThan(1));
    }
}
