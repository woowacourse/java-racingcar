package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void 빈_문자열() {
        int num = calculator.splitAndSum("");
        assertThat(num).isEqualTo(0);
    }

    @Test
    public void 인자_없음() {
        int num = calculator.splitAndSum(null);
        assertThat(num).isEqualTo(0);
    }

    @Test
    public void 인자_하나() {
        int num = calculator.splitAndSum("1");
        assertThat(num).isEqualTo(1);
    }

    @Test
    public void 인자_두개_콤마_구별자() {
        int num = calculator.splitAndSum("1,2");
        assertThat(num).isEqualTo(3);
    }

    @Test
    public void 인자_두개_콜론_구분() {
        int num = calculator.splitAndSum("1:2");
        assertThat(num).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자를 기준으로 분리해서 합계를 반환한다.")
    @Test
    public void 커스텀_구분자를_지정_assertThat() {
        int result = calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("인자로 음수를 하나 이상 전달할 경우 예외를 반환한다.")
    @Test
    public void 음수_전달시_예외_처리() {
        assertThatThrownBy(() -> {
            calculator.splitAndSum("-1,2");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 불가합니다!");
    }
}
