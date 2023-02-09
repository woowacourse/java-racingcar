package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        String name = "example";
        car = new Car(name);
    }

    @Test
    void updatePosition_test() {
        car.updatePosition();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}