package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    @DisplayName("1보다 작은 숫자를 입력하면 예외가 발생한다..")
    void movingCountInputLessThanMinValue() {
        String input = "0";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMovingCountInput(input));
    }

    @Test
    @DisplayName("숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    void movingCountInputNonDigit() {
        String input = "a";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMovingCountInput(input));
    }
}