package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Validator;

// TODO : validateCountRangeTest()메서드 보다 명확한 네이밍으로 수정
class MovingCountTest {
    @Test
    void validateCountRangeTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMovingCountInput("0"));
    }
}
