package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 생성자_null() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 생성자_5글자초과() {
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }

}