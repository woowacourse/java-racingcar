package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringValidatorTest {
    @DisplayName("validateIsEmpty 메소드는")
    @Nested
    class validateIsEmpty {
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 빈_값_이라면(String input) {
            assertThatThrownBy(() -> StringValidator.validateIsEmpty(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열은 빈값이면 안됩니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "1111"})
        void 빈_값이_아니라면(String input) {
            assertDoesNotThrow(() -> StringValidator.validateIsEmpty(input));
        }
    }

    @DisplayName("validateLength 메소드는")
    @Nested
    class validateLength {
        @ParameterizedTest
        @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
        void 한글자_이상_다섯글자_이하_라면(String input) {
            assertDoesNotThrow(() -> StringValidator.validateLength(input, 1, 5));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abcdef"})
        void 한글자_이상_다섯글자_이하가_아니라면(String input) {
            assertThatThrownBy(() -> StringValidator.validateLength(input, 1, 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열의 길이가 1 이상 5 이하가 아닙니다.");
        }
    }

    @DisplayName("validateFormat 메소드는")
    @Nested
    class validateFormat {
        @ParameterizedTest
        @ValueSource(strings = {"hudi", "tonic", "a", "토닉", "후디", "123"})
        void 올바른_형식의_문자열이라면(String input) {
            assertDoesNotThrow(() -> StringValidator.validateFormat(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {" ", "ton*&", "?a1"})
        void 올바른_형식의_문자열이_아니라면(String input) {
            assertThatThrownBy(() -> StringValidator.validateFormat(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바르지 않은 형식의 문자열입니다.");
        }
    }
}