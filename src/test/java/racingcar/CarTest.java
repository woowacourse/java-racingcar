package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarTest {

    @Test
    public void move() {
        Car car = new Car("Thor");
        car.move();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}