package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    void createTest() {
        assertThat(new Car("TOAST")).isEqualTo(new Car("TOAST"));
    }

    @Test
    void invalidCreateTest1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("LONG NAME");
        });
    }

    @Test
    void invalidCreateTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void invalidCreateTest3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void moveTest() {
        assertThat(new Car("TOAST", 6).moveOrStop(new ForceMove()).isAtSamePositionWith(new Car("TEST", 7))).isTrue();
    }

    @Test
    void stopTest() {
        assertThat(new Car("TOAST", 6).moveOrStop(new ForceStop()).isAtSamePositionWith(new Car("TEST", 6))).isTrue();
    }

    @Test
    void isAtSamePositionWithTest() {
        assertThat(new Car("TOAST", 15).isAtSamePositionWith(new Car("TEST", 15))).isTrue();
    }

    @Test
    void compareToTest() {
        assertThat(new Car("TOAST", 6).compareTo(new Car("TEST", 8))).isEqualTo(2);
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

class ForceStop implements MovementStrategy {
    public boolean isMovable() {
        return false;
    }
}