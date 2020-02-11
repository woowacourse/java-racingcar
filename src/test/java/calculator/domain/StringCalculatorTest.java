package calculator.domain;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    public void calculate() {
        String value = "1,2:3";
        assertThat(StringCalculator.run(value)).isEqualTo(6);

        value = "1:6,3";
        assertThat(StringCalculator.run(value)).isEqualTo(10);

        value = "";
        assertThat(StringCalculator.run(value)).isEqualTo(0);

        value = null;
        assertThat(StringCalculator.run(value)).isEqualTo(0);
    }

    @Test
    @DisplayName("커스텀 한 구분자를 사용하는 경우 테스트")
    public void customDelimiter () {
        String delimiter = "//;\n1;2;3";
        assertThat(StringCalculator.run(delimiter)).isEqualTo(6);
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

