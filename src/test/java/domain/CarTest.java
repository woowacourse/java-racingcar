package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void judgeMoveFromRandomNum() {
        assertThat(car.judgeMove(4)).isEqualTo("Go");
        assertThat(car.judgeMove(3)).isEqualTo("Stop");
    }
}
