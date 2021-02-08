package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "12,12", "123,123"})
    public void splitAndSum_숫자하나(String input, int expectedResult) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "12,23=35", "1,2,3,4=10"}, delimiter = '=')
    public void splitAndSum_쉼표구분자(String input, int expectedResult) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "12:23=35", "1:2,3:4=10"}, delimiter = '=')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expectedResult) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void splitAndSum_custom_구분자2() throws Exception {
        int result = StringCalculator.splitAndSum("//!\n12!23");
        assertThat(result).isEqualTo(35);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}