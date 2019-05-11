package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    void 값이4미만일경우_움직이지않는다() {
        Car car = new Car("test");
        assertThat(car.move(3)).isEqualTo(new Car("test", 0));
    }

    @Test
    void 값이4이상일경우_움직인다() {
        Car car = new Car("test");
        assertThat(car.move(4)).isEqualTo(new Car("test", 1));
    }

    @Test
    void 이름의길이가6이상일때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("testtest");
        });
    }

    @Test
    void 이름의공백이들어올때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 포지션음수인경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("test", -1);
        });
    }
}