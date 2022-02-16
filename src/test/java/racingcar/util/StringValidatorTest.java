package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringValidatorTest {
    @DisplayName("validateIsEmpty 메소드는")
    @Nested
    class ValidateIsEmpty {
        @Nested
        @DisplayName("빈 값이 주어지면")
        class Context_with_blank {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {""})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> StringValidator.validateIsEmpty(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열은 빈값이면 안됩니다.");
            }
        }
    }

    @DisplayName("validateLength 메소드는")
    @Nested
    class ValidateLength {
        @Nested
        @DisplayName("한글자 이상 다섯글자 이하가 아니라면")
        class Context_with_incorrect_length {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {"", "abcdef"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> StringValidator.validateLength(input, 1, 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열의 길이가 1 이상 5 이하가 아닙니다.");
            }
        }
    }

    @DisplayName("validateFormat 메소드는")
    @Nested
    class ValidateFormat {
        @Nested
        @DisplayName("올바른_형식의_문자열이_아니라면")
        class Context_with_incorrect_format {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {" ", "ton*&", "?a1"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> StringValidator.validateFormat(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바르지 않은 형식의 문자열입니다.");
            }
        }
    }
}
