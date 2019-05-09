package racingcargame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @Test
    void move_test() {
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(8);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
