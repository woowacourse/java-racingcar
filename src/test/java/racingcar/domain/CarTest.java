package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    void initTestA() {
        assertThrows(Exception.class, () -> {
            new Car("", 3);
        });
    }

    @Test
    void initTestB() {
        assertThrows(Exception.class, () -> {
            new Car("asfdsgs", 6);
        });
    }

    @Test
    void movementTest() {
        assertThat(new Car("TOAST", 4).move(new ForceMove()).isAtSamePositionWith(new Car("TEST", 5))).isTrue();
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
    void trailDrawingTest() {
        assertThat(new Car("TOAST", 7).drawTrail()).isEqualTo("-------");
    }
}

class ForceMove implements MovementStrategy {
    public boolean isMovable() {
        return true;
    }
}