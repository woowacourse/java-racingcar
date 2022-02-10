package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void splitAndSum_nullOrEmpty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "5"})
    void splitAndSum_oneNumber(String input) {
        int result = StringCaculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2,3|6"}, delimiter = '|')
    void splitAndSum_commaSeparator(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3|4", "2:3|5"}, delimiter = '|')
    void splitAndSum_colonSeparator(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "3:4,5|12"}, delimiter = '|')
    void splitAndSum_multipleSeparators(String input, String resultString) {
        int result = StringCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(toInt(resultString));
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }
}
