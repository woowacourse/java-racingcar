package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @Test
    @DisplayName("null 또는 빈문자열이면 0이 되는지 테스트")
    void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나인 문자열이 숫자가 되는지 테스트")
    void splitAndSum_숫자하나() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마로 구분된 숫자가 더해지는지 테스트")
    void splitAndSum_쉼표구분자() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마와 콜론으로 구분된 숫자가 더해지는지 테스트")
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 작동하는지 테스트")
    void splitAndSum_custom_구분자() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어가면 에러가 나는지 테스트")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("알파벳이 들어가면 에러가 나는지 테스트")
    void splitAndSum_alphabet() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1,a,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
