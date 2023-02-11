package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberValidatorTest {

    @DisplayName("양의 정수가 아닌 값이 들어오면 예외를 던진다")
    @ParameterizedTest
    @CsvSource({"''", "abc", "-1", "0", "3.3"})
    void should_ThrowIllegalArgumentException_When_InputIsNotPositiveInteger(String input) {
        assertThatThrownBy(() -> NumberValidator.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("양의 정수가 들어오면 예외를 던지지 않는다")
    @ParameterizedTest
    @CsvSource({"1", "5", "1000"})
    void should_DoesNotThrowException_When_InputIsPositiveInteger(String input) {
        assertThatCode(() -> NumberValidator.parseInt(input))
                .doesNotThrowAnyException();
    }
}
