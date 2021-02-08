package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.exception.IllegalCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterPositionException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5", "6:6", "7:7", "8:8", "9:9", "0:0"}, delimiter = ':')
    public void splitAndSum_숫자하나(String input, int expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "1,2,3|6", "1:2:3|6", "4,5:6|15"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 입력의 제일 앞이 아니라면 예외")
    @ValueSource(strings = {"3;//;\n1;2;3", "1;2;3//;\n"})
    public void splitAndSum_custom_구분자가_맨_앞이_아니면_예외(String input) {
        assertThatExceptionOfType(IllegalCustomDelimiterPositionException.class)
                .isThrownBy(() -> StringCalculator.splitAndSum(input));
    }

    @ParameterizedTest
    @DisplayName("구분자가 숫자로 들어올 경우 예외")
    @ValueSource(strings = {"//1\n1;2;3"})
    public void splitAndSum_custom_구분자가_숫자로_들어올_경우_예외(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(IllegalCustomDelimiterException.class);
    }

    @ParameterizedTest
    @DisplayName("입력 데이터를 분리하고 덧셈하여 출력한")
    @MethodSource("provideInputsFor_구분자로_구분된_숫자들의_합을_반환")
    public void splitAndSum_구분자로_구분된_숫자들의_합을_반환(String input, String expected) {
        assertEquals(Integer.valueOf(expected), StringCalculator.splitAndSum(input));
    }

    @ParameterizedTest
    @DisplayName("분리 된 문자열 중 숫자가 아닌 것이 있는지 체크 한다.")
    @ValueSource(strings = {"//|\na|b|c", "a,b:c", "//;\n|;|;3", "1,b:3"})
    public void splitAndSum_분리_된_문자가_숫자가_아니면_예외(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> StringCalculator.splitAndSum(input)
        );
    }

    @ParameterizedTest
    @DisplayName("분리 된문자열 중 음수가 있다면 예외")
    @ValueSource(strings = {"1,2:-3", "1,2:-3:3", "1,-2:-1", "-1,2:-3", "//|\n1|1|-1", "//|\n1|-1|-1", "//|\n-1|1|-1"})
    public void splitAndSum_분리_된_문자열_중_음수가_있다면_예외(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> StringCalculator.splitAndSum(input)
        );
    }

    private static Stream<Arguments> provideInputsFor_구분자로_구분된_숫자들의_합을_반환() {
        return Stream.of(
                Arguments.of("//|\n1|2|3", "6"),
                Arguments.of("//!\n1!2!3", "6"),
                Arguments.of("1,2:3", "6"),
                Arguments.of("1:2,3", "6"),
                Arguments.of("1:2:3", "6"),
                Arguments.of("1,2,3", "6")
        );
    }
}
