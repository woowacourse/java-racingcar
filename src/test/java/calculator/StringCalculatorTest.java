package calculator;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10, 20})
    public void splitAndSum_숫자하나(int number) throws Exception {
        int result = StringCalculator.splitAndSum(Integer.toString(number));
        assertThat(result).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2#3", "1,2,3#6", "2,3,5#10"}, delimiter = '#')
    public void splitAndSum_쉼표구분자(String input, String expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2#3", "1,2:3#6", "2:3,5#10"}, delimiter = '#')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, String expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @MethodSource("methodSourceTest")
    public void splitAndSum_custom_구분자(String input, int expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,5", "1,3,-10"})
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
            arguments("//;\n1;2;3", 6),
            arguments("//@\n1@3@5", 9),
            arguments("//!\n2!3!5", 10)
        );
    }
}