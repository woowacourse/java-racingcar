package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void moveOrStopTest() {
        assertThat(new Car("TOAST", 6).moveOrStop(new ForceMove()).isAtSamePositionWith(new Car("TEST", 7))).isTrue();
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