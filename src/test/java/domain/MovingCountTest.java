package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Validator;

class MovingCountTest {
    @Test
    void validateCountRangeTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMovingCountInput("0"));
    }
}