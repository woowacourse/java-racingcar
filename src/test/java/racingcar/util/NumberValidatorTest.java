package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumberValidatorTest {
    @DisplayName("validateIsNumber 메소드에 올바른 숫자가 전달되면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "32462", "00214", "-2514"})
    void validateIsNumberWithValidInput(String input) {
        assertDoesNotThrow(() -> NumberValidator.validateStringIsNumber(input));
    }

    @DisplayName("validateIsNumber 메소드에 숫자가 아닌 문자열이 전달되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "24ab", "333,333", "", "-"})
    void validateIsNumberWithNotNumber(String input) {
        assertThatThrownBy(() -> NumberValidator.validateStringIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 숫자여야 합니다.");
    }

    @DisplayName("validateIsPositive 메소드에 양수가 전달되면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 22, 333})
    void validateIsPositiveWithValidInput(int input) {
        assertDoesNotThrow(() -> NumberValidator.validateIsPositive(input));
    }

    @DisplayName("validateIsPositive 메소드에 양수가 아닌 숫자가 전달되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -22, 0})
    void validateIsPositiveWithNotPositive(int input) {
        assertThatThrownBy(() -> NumberValidator.validateIsPositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수여야 합니다.");
    }

    @DisplayName("validateIsNotNegative 메소드에 음수가 아닌 숫자가 전달되면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 22, 333})
    void validateIsNotNegativeWithValidInput(int input) {
        assertDoesNotThrow(() -> NumberValidator.validateIsNotNegative(input));
    }

    @DisplayName("validateIsNotNegative 메소드에 음수가 전달되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -22})
    void validateIsNotNegativeWithNegative(int input) {
        assertThatThrownBy(() -> NumberValidator.validateIsNotNegative(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 음수일 수 없습니다.");
    }
}
