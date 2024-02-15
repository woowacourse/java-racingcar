package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차는 random 값이 4 이상이면 전진한다.")
    void move() {
        Car car = new Car("pobi");
        car.move(4);

        int result = car.getPosition();
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 random 값이 3 이하이면 전진하지 않는다.")
    void stop() {
        Car car = new Car("pobi");
        car.move(3);

        int result = car.getPosition();
        assertThat(result).isEqualTo(0);
    }
}