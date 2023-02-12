package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @Test
    void moveTest() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void nameTest() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    void positionTest() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
