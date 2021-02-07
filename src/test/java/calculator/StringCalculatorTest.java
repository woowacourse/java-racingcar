package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("splitAndSum null 또는 빈문자")
    void splitAndSum_null_or_empty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("splitAndSum 숫자 하나")
    void splitAndSum_single_number() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("splitAndSum ','구분자")
    void splitAndSum_comma_delimiter() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("splitAndSum ',' 또는 ':' 구분자")
    void splitAndSum_comma_or_colon_delimiter() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 커스텀 구분자")
    void splitAndSum_custom_delimiter() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 음수 포함")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("splitAndSum 커스텀 구분자와 ',' 구분자 모두 포함")
    void splitAndSum_custom_delimiter_and_comma() {
        int result = StringCalculator.splitAndSum("//;\n1;2,3");
        assertThat(result).isEqualTo(6);
    }
}