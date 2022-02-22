package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    @DisplayName("null 값")
    public void nullValue() {
        int result = StringCalculator.caculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자")
    public void emptyValue() {
        int result = StringCalculator.caculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 1개")
    public void number1() {
        int result = StringCalculator.caculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자")
    public void delimiter() {
        int result = StringCalculator.caculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자")
    public void dilimiter2() {
        int result = StringCalculator.caculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    public void dilimiter3() {
        int result = StringCalculator.caculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수")
    public void negative() {
        assertThatThrownBy(() -> StringCalculator.caculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자")
    public void stringValue() {
        assertThatThrownBy(() -> StringCalculator.caculate("test"))
                .isInstanceOf(RuntimeException.class);
    }
}