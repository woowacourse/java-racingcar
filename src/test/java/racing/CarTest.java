package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("Lamborghini");
    }

    @Test
    void 전진잘하나요() {
        assertThat(car.goOrStop(5)).isEqualTo(true);
    }

    @Test
    void 후진잘하나요() {
        assertThat(car.goOrStop(3)).isEqualTo(false);
    }
}