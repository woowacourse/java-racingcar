package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("시도횟수")
class MovingCountValidatorTest {

    @DisplayName("1~100사이의 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0","101"})
    void validateMovingCountRangeTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MovingCountValidator.validateMovingCountInput(input));
    }

    @DisplayName("숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a",""})
    void validateMovingCountIsDigitTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MovingCountValidator.validateMovingCountInput(input));
    }
}
