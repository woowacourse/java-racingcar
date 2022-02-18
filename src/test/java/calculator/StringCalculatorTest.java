package calculator;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("splitAndSum 메서드는 null 혹은 빈 문자열이 입력된 경우 0을 반환한다.")
    @Test
    void splitAndSum_nullOrEmpty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @DisplayName("splitAndSum 메서드는 숫자 하나가 문자열로 입력된 경우 해당 숫자를 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"1", "2", "5"})
    void splitAndSum_oneNumber(String input) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(input));
    }

    @DisplayName("splitAndSum 메서드는 복수의 숫자를 쉼표(,) 구분자로 입력할 경우 숫자들의 합을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1,2|3", "1,2,3|6"}, delimiter = '|')
    void splitAndSum_commaSeparator(String input, int result) {
        int sum = StringCalculator.splitAndSum(input);

        assertThat(sum).isEqualTo(result);
    }

    @DisplayName("splitAndSum 메서드는 복수의 숫자를 콜론(:) 구분자로 입력할 경우 숫자들의 합을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1:3|4", "2:3:4|9"}, delimiter = '|')
    void splitAndSum_colonSeparator(String input, int result) {
        int sum = StringCalculator.splitAndSum(input);

        assertThat(sum).isEqualTo(result);
    }

    @DisplayName("splitAndSum 메서드는 다양한 구분자가 함께 입력되더라도 예외가 발생하지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1,2:3|6", "3:4,5|12"}, delimiter = '|')
    void splitAndSum_multipleSeparators(String input, int result) {
        int sum = StringCalculator.splitAndSum(input);

        assertThat(sum).isEqualTo(result);
    }

    @DisplayName("splitAndSum 메서드는 커스텀 구분자를 받아 사용할 수 있다.")
    @Test
    void splitAndSum_customSeparator() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum 메서드는 숫자 이외의 값이 입력된 경우 예외가 발생한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"A", "A,1", "가:2"})
    void splitAndSum_nonIntegerThrowsException(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum 메서드는 음수가 입력된 경우 예외가 발생한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"-1", "-1,2", "1:2:-3"})
    void splitAndSum_negativeIntegerThrowsException(String input) {
        String exceptionMessage = "음수를 입력하면 안 됩니다.";

        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(exceptionMessage);
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }
}
