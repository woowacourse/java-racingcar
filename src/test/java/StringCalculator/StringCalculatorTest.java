package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("커스텀 구분자를 적용한 문자열 덧셈 기능")
    @ParameterizedTest
    @MethodSource
    void splitAndSumWhenApplyCustomDelimiter(String input) {
        String[] stringAndResult = input.split("#");
        String string = stringAndResult[0];
        String result = stringAndResult[1];
        assertThat(StringCalculator.splitAndSum(string)).isEqualTo(Integer.parseInt(result));
    }

    private static Stream<String> splitAndSumWhenApplyCustomDelimiter() {
        return Stream.of(
                "//;\n1;2;3#6",
                "//@\n1@3@6#10",
                "//!\n1!3!5#9",
                "//%\n20%4%1#25"
        );
    }

    @DisplayName("기본 구분자를 적용한 문자열 덧셈 기능")
    @Test
    void splitAndSumWhenApplyDefaultDelimiter() {
        String string = "1,2,3";
        assertThat(StringCalculator.splitAndSum(string)).isEqualTo(6);
    }

    @DisplayName("null 또는 비어있는 문자열을 더하면 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSumWhenStringIsNullAndEmpty(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("기본 구분자가 섞여있는 문자열의 문자열 덧셈")
    @Test
    void splitAndSumWhenComplexDefaultDelimiters() {
        String string = "1,2:3";
        assertThat(StringCalculator.splitAndSum(string)).isEqualTo(6);
    }

    @DisplayName("문자열 숫자에 음수가 있으면 예외를 발생시킨다")
    @Test
    public void splitAndSumWhenNumbersHasNegative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 숫자의 개수가 1개인 경우 첫 번째 값을 리턴한다")
    @Test
    public void splitAndSumWhenNumbersLengthIsOne() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }
}
