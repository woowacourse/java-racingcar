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
    void runTest() {
        Car car = new Car("TOAST");
        car.run(new ForceMove());
        car.run(new ForceMove());
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void stopTest() {
        Car car = new Car("TOAST");
        car.run(new ForceStop());
        car.run(new ForceStop());
        assertThat(car.getPosition()).isEqualTo(0);
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