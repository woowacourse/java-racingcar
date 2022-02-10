package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.*;

public class StringCalculatorTest {

    private final String PARAMETERIZED_TEST_DISPLAY_FORMAT =
            DISPLAY_NAME_PLACEHOLDER + " ["
            + ARGUMENTS_PLACEHOLDER + "]";

    @DisplayName("splitAndSum 메서드는 null 혹은 빈 문자열이 입력된 경우 0을 반환한다.")
    @Test
    void splitAndSum_nullOrEmpty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
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
    void splitAndSum_commaSeparator(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    @DisplayName("splitAndSum 메서드는 복수의 숫자를 콜론(:) 구분자로 입력할 경우 숫자들의 합을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1:3|4", "2:3:4|9"}, delimiter = '|')
    void splitAndSum_colonSeparator(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    @DisplayName("splitAndSum 메서드는 다양한 구분자가 함께 입력되더라도 예외가 발생하지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"1,2:3|6", "3:4,5|12"}, delimiter = '|')
    void splitAndSum_multipleSeparators(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }
}
