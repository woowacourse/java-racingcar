package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("Mery");
    }

    @Test
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}