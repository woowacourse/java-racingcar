package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void moveAndReturnPositionTest() {
        assertThat(new Car("TOAST", 6).moveAndReturnPosition(new ForceMove())).isEqualTo(7);
    }

    @Test
    void isAtTest() {
        assertThat(new Car("TOAST", 65535).isAt(65535)).isEqualTo(true);
    }

    @Test
    void toStringTest() {
        assertThat(new Car("TOAST").toString()).isEqualTo("TOAST");
    }
}

class ForceMove implements MovementStrategy {
    public boolean isMovable() {
        return true;
    }
}