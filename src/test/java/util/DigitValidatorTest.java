package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitValidatorTest {
    @DisplayName("입력이 숫자가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "1a", "a1", "a1a"})
    void validateIsDigitTest(String input) {
        assertThatThrownBy(() -> DigitValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 숫자이어야 합니다.");
    }

    @DisplayName("입력이 숫자이면 예외를 던지지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "123", "1234567890"})
    void validateIsDigitTest2(String input) {
        assertThatCode(() -> DigitValidator.validateIsDigit(input))
                .doesNotThrowAnyException();
    }
}
