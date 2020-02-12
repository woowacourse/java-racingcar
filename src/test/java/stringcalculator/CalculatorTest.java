package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private static Stream<Arguments> sourceForNegativeException() {
        return Stream.of(
                Arguments.of("1,2:-3", -3),
                Arguments.of("//;\n1;2;-5", -5)
        );
    }

    @Test
    void customPlusTest() {
        assertThat(Calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    void plusTest(String input, int result) {
        assertThat(Calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("sourceForNegativeException")
    void inputNegativeThrowIllegalException(String input, int negative) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%d는 음수입니다.", negative);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = Calculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = Calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = Calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = Calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
