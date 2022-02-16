package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    private static Stream<Arguments> inputOnlySplitters() {
        return Stream.of(
                Arguments.of(",", 0),
                Arguments.of("//\n", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputOnlySplitters")
    @DisplayName("구분자만 입력한 경우 예외처리")
    void onlySplitterInput(String given, int expected) {
        int actual = StringCalculator.splitAndSum(given);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> blankOrNullParams() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("blankOrNullParams")
    @DisplayName("빈 문자열 또는 null을 입력한 경우")
    void blankInputException(String given, int expected) {
        int actual = StringCalculator.splitAndSum(given);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 하나만 입력한 경우")
    void singleInput() {
        int actual = StringCalculator.splitAndSum("15");
        int expected = 15;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자에 여러 문자가 포함된 경우")
    void severalCharactersOnCustom() {
        int actual = StringCalculator.splitAndSum("//@@..\n5@@..6@@..4");
        int expected = 15;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자가 포함된 경우 예외처리")
    void numbersOnCustomSplitterException() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//..2.\n1..2.4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("커스텀 구분자 내에 숫자");
    }

    @Test
    @DisplayName("숫자 이외의 값을 입력한 경우 예외처리")
    void inputNotNumbersException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"a", "b"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자여야 합니다");
    }

    @Test
    @DisplayName("음수를 입력한 경우 예외처리")
    void inputNegativeNumberException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"-1", "-2"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0 이상의 정수");
    }

    @Test
    @DisplayName("소수값을 입력한 경우 예외처리")
    void inputDecimalException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"1.1", "2.3"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("소수가 아닌");
    }
}
