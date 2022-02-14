package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void move() {
        Car car = new Car("Thor");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}