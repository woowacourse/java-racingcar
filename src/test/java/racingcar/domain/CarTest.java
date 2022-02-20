package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void isSamePosition() {
        Car car = new Car("test");
        car.move();
        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    void isNotInSamePosition() {
        Car car = new Car("test");
        assertThat(car.isSamePosition(1)).isFalse();
    }
}
