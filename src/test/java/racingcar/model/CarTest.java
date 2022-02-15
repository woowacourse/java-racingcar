package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void move() {
        Car car = new Car("Thor");
        car.tryMove(5);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }
}