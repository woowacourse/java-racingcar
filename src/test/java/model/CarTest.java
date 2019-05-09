package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 차이름길이_예외검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("asdefg");
        });
    }

    @Test
    void 차이름_영문검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("a1das");
        });
    }
}