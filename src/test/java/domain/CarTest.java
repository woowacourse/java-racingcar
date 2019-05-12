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
    void create_5자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("aaaaaa");
        });
    }

    @Test
    void 정지() {
        assertThat(car.move(Rule.isMove(3))).isEqualTo(0);
    }

    @Test
    void 이동() {
        assertThat(car.move(Rule.isMove(4))).isEqualTo(1);
        assertThat(car.move(Rule.isMove(9))).isEqualTo(2);
    }

    @Test
    void 움직임_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            car.move(Rule.isMove(-1));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            car.move(Rule.isMove(10));
        });
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}
