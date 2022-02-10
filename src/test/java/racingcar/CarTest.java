package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 자동차_이동() {
        Car car = new Car("bravo", 0, () -> 5);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    public void 자동차_중지() {
        Car car = new Car("bravo", 0, () -> 1);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
