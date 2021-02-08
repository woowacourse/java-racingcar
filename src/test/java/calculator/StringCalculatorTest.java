package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("null이나 공백 입력 시 0 반환")
    public void splitAndSum_null_or_blank() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력시 숫자 반환")
    public void splitAndSum_only_number() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 확인")
    public void splitAndSum_comma_delimiter() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표, 콜론 구분자 확인")
    public void splitAndSum_comma_colon_delimiter() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    public void splitAndSum_custom_delimiter() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
        int result2 = StringCalculator.splitAndSum("//%\n4%%1%");
        assertThat(result2).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 입력시 예외 처리")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/;\n1,2,3", "//\n1:2:33", "//;\n-1;10"})
    @DisplayName("옳지 않은 custom 구분자 입력 검증")
    public void splitAndSum_several_custom_delimiter_exception(String text) throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
