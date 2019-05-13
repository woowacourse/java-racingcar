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
    void moveTest() {
        assertThat(new Car("TOAST", 4).move(new AlwaysMove()).compareTo(new Car("TEST", 5))).isEqualTo(0);
    }

    @Test
    void stopTest() {
        assertThat(new Car("TOAST", 4).move(new AlwaysStop()).compareTo(new Car("TEST", 4))).isEqualTo(0);
    }
}