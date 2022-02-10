package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumberValidatorTest {
    @DisplayName("validateIsNumber 메소드는")
    @Nested
    class validateStringIsNumber {
        @ParameterizedTest
        @ValueSource(strings = {"a", "24ab", "333,333", "", "-"})
        void 숫자가_아닌_문자열이라면(String input) {
            assertThatThrownBy(() -> NumberValidator.validateStringIsNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력은 숫자여야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "32462", "00214", "-2514"})
        void 숫자인_문자열이라면(String input) {
            assertDoesNotThrow(() -> NumberValidator.validateStringIsNumber(input));
        }
    }

    @DisplayName("validateIsPositive 메소드는")
    @Nested
    class validateIsPositive {
        @ParameterizedTest
        @ValueSource(ints = {-1, -22, 0})
        void 양수가_아니라면(int input) {
            assertThatThrownBy(() -> NumberValidator.validateIsPositive(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 양수여야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 22, 333})
        void 양수라면(int input) {
            assertDoesNotThrow(() -> NumberValidator.validateIsPositive(input));
        }

    }
}
