package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        Car car = new Car("test");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void isSamePosition() {
        Car car = new Car("test", 3);
        assertThat(car.isSamePosition(3)).isTrue();
    }
}