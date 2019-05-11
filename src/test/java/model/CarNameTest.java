package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {
    @Test
    void 자동차이름_길이_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(new CarName("Aidenn"));
        });
    }

    @Test
    void 자동차이름_영어_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(new CarName("0A1"));
        });
    }
}