package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidatorTest {
    @DisplayName("validateIsNumber 메소드는")
    @Nested
    class ValidateStringIsNumber {
        @Nested
        @DisplayName("숫자가 아닌 문자열이 주어지면")
        class Context_with_string {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {"a", "24ab", "333,333", "", "-"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> NumberValidator.validateStringIsNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력은 숫자여야 합니다.");
            }
        }
    }

    @DisplayName("validateIsPositive 메소드는")
    @Nested
    class ValidateIsPositive {
        @Nested
        @DisplayName("양수가 아니라면")
        class Context_with_not_positive_number {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(ints = {-1, -22, 0})
            void it_throw_exception(int input) {
                assertThatThrownBy(() -> NumberValidator.validateIsPositive(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 양수여야 합니다.");
            }
        }
    }

    @DisplayName("validateIsNotNegative 메소드는")
    @Nested
    class ValidateIsNotNegative {
        @Nested
        @DisplayName("음수라면")
        class Context_with_negative_number {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(ints = {-1, -22})
            void it_throw_exception(int input) {
                assertThatThrownBy(() -> NumberValidator.validateIsNotNegative(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 음수일 수 없습니다.");
            }
        }
    }
}
