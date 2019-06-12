package domain;

import exception.CarNameLenExceedException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @Test
    void from_null() {
        assertThrows(IllegalArgumentException.class, () -> CarName.from(null));
    }

    @Test
    void from_빈이름() {
        assertThrows(IllegalArgumentException.class, () -> CarName.from(""));
    }

    @Test
    void from_이름이6글자이상인경우() {
        assertThrows(CarNameLenExceedException.class, () -> CarName.from("123456"));
    }
}