package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("붕붕이");
    }

    @Test
    void create() {
        assertThat(car).isEqualTo(new Car("붕붕이"));
    }

    @Test
    void create_5자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("aaaaaa");
        });
    }

    @Test
    void 움직임판단() {
        assertThat(car.judgeMove(3)).isEqualTo(0);
        assertThat(car.judgeMove(4)).isEqualTo(1);
        assertThat(car.judgeMove(9)).isEqualTo(1);
        assertThat(car.judgeMove(-1)).isEqualTo(-1);
        assertThat(car.judgeMove(10)).isEqualTo(-1);
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}
