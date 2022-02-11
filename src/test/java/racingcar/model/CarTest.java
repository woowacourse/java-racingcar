package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void move() {
        Car car = new Car("Thor");
        car.move();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}