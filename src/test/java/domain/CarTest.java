package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void create() {
        assertThat(car).isEqualTo(new Car("car"));
    }

    @Test
    void create_but_name_is_null() {
        assertThrows(NullPointerException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void create_but_name_is_too_short() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void create_but_name_is_too_long() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("caaaar");
        });
    }

    @Test
    void get_bigger_position() {
        assertThat(car.getBiggerPosition(-1)).isEqualTo(0);
    }

    @Test
    void is_max_position() {
        assertThat(car.isMaxPosition(0)).isTrue();
        assertThat(car.isMaxPosition(1)).isFalse();
    }

    /* 가능하면 테스트 단위는 작게 > GO와 STOP 분리 */
    @Test
    void judgeMove() {
        assertThat(car.judgeMove(4)).isEqualTo("Go");
        assertThat(car.judgeMove(3)).isEqualTo("Stop");
    }
}
