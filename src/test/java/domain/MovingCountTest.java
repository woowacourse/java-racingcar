package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovingCountTest {
    @Test
    void validateCountRangeTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MovingCount(0));
    }
}