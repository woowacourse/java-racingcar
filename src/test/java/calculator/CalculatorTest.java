package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.exception.NumberExceptionStatus;
import calculator.exception.WrongArgumentException;

class CalculatorTest {

    private final Separator separator = new Separator();
    private final Calculator calculator = new Calculator(separator);

    private void exceptionText(final String text, final String errorMessage) {
        assertThatThrownBy(() -> calculator.splitAndSum(text))
                .isInstanceOf(WrongArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @DisplayName("숫자 이외의 값은 입력할 수 없습니다")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\"")
    @ValueSource(strings = {"a", "1,a"})
    void numberIsNotNumericExceptionTest(final String text) {
        final String errorMessage = NumberExceptionStatus.NUMBER_IS_NOT_NUMERIC.getMessage();
        exceptionText(text, errorMessage);
    }

    @DisplayName("음수는 입력할 수 없습니다")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\"")
    @ValueSource(strings = {"-1", "1,-1"})
    void numberIsNegativeExceptionTest(final String text) {
        final String errorMessage = NumberExceptionStatus.NUMBER_IS_NEGATIVE.getMessage();
        exceptionText(text, errorMessage);
    }

    private void calculatorSumTest(final String text, final int expected) {
        final int result = calculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("NULL 또는 공백 입력 시, 0을 반환")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\"")
    @NullAndEmptySource
    void nullOrEmptyInputTest(final String text) {
        calculatorSumTest(text, 0);
    }

    @DisplayName("문자열 덧셈 기능 테스트")
    @ParameterizedTest(name = "[{index}] 입력 : \"{0}\"")
    @MethodSource("provideForSplitAndSumTest")
    void splitAndSumTest(final String text, final int expected) {
        calculatorSumTest(text, expected);
    }

    private static Stream<Arguments> provideForSplitAndSumTest() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("1,2:4", 7),
                Arguments.of("1,2:2,1", 6),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//;*#\n1*2#3", 6),
                Arguments.of("//;\n1;2;3,4:1", 11),
                Arguments.of("//(;)\n1;2;3(4)1", 11)
        );
    }

}
