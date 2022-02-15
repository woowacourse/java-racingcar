package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자를 넣으면 0을 반환한다")
    public void splitAndSumWithNullOrEmpty(String text) throws Exception {
        int result = StringCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 넣으면 해당 숫자를 반환한다")
    public void splitAndSumWithOneNumber() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마로 구분하여 덧셈한다")
    public void splitAndSumWithComma() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마 또는 콜론으로 구분하여 구분한다")
    public void splitAndSumWithCommaOrColon() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 구분한다")
    public void splitAndSumWithCustomDelimiter() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어가면 예외를 반환한다")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}