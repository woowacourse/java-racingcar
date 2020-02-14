package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("null 또는 빈 문자를 입력했을 때")
    public void nullOrBlankSplitTest() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 입력했을 때")
    public void oneNumberTest() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 여러 개 입력했을 때")
    public void commaSeparatedValuesTest() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자와 콜론(:)으로 구분된 숫자 여러 개 입력했을 때")
    public void commaAndColonSeparatedValuesTest() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 때")
    public void splitWithCustomValueTest() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력했을 때")
    public void negativeIntIncludedTest() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @Test
    @DisplayName("구분자를 두번 입력했을 때")
    public void duplicateDelimeterTest() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1,,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("빈 값");
    }
}