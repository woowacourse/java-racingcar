package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 값이4이상일경우_움직인다() {
        Car car = new Car("testCar");
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(2);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(5);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}