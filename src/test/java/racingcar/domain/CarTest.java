package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void moveAndReturnPositionTest() {
        assertThat(new Car("TOAST", 6).moveAndReturnPosition(new ForceMove())).isEqualTo(7);
    }

    @Test
    void compareToTest() {
        assertThat(new Car("TOAST", 6).compareTo(new Car("TEST", 8))).isEqualTo(2);
    }

    @Test
    void isAtSamePositionWithTest() {
        assertThat(new Car("TOAST", 15).isAtSamePositionWith(new Car("TEST", 15))).isTrue();
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