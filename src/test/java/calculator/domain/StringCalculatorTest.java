package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    private static final String NORMAL_INPUT = "1,2:3";
    private static final String EMPTY = "";
    private static final String SINGLE_NUMBER = "1";
    private static final String ONLY_COMMA = "1,2";

    @ParameterizedTest
    @CsvSource(value = {NORMAL_INPUT + "-6",EMPTY + "-0",SINGLE_NUMBER+ "-1",ONLY_COMMA+ "-3"}, delimiter = '-')
    @DisplayName("커스텀 없이, 정상적인 경우")
    public void calculate(String input, int expected) {
        assertThat(StringCalculator.run(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 한 구분자를 사용하는 경우 테스트")
    public void customDelimiter () {
        String delimiter = "//;\n1;2;3";
        assertThat(StringCalculator.run(delimiter)).isEqualTo(6);
    }

    @Test
    @DisplayName("널값이 입력되는 경우")
    public void nullTest() {
        String value = null;
        assertThat(StringCalculator.run(value)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 아니거나 음수가 입력되는 경우 정상적으로 예외를 내는지")
    public void numberFormatTest() {
        String value = "-1,2:4";
        assertThatThrownBy(()->{
            StringCalculator.run(value);
        }).isInstanceOf(RuntimeException.class);
    }
}

