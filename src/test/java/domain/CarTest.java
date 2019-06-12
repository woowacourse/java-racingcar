package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move_움직이는_경우() {
        CarName name = CarName.from("a");
        Distance distance = Distance.from(0);
        Car car = Car.of(name, distance);

        assertThat(car.move(TestMoveStrategy.MOVE)).isEqualTo(car.of(name, distance.increased()));
    }

    @Test
    void move_멈추는_경우() {
        CarName name = CarName.from("a");
        Distance distance = Distance.from(0);
        Car car = Car.of(name, distance);

        assertThat(car.move(TestMoveStrategy.DONT_MOVE)).isEqualTo(car.of(name, distance));
    }
}
