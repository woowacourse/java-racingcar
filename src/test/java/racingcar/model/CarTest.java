package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("자동차1");

        car.move();

        assertThat(car.getProgress()).isEqualTo(1);
    }
}