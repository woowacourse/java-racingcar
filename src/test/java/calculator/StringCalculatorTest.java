package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @DisplayName("빈 문자열인 경우 0을 반환한다.")
    @Test
    void splitAndSum_빈문자열() {
        int result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null인 경우 0을 반환한다.")
    @Test
    void splitAndSum_null() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자열이 주어지면 `쉼표(,)` 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("문자열이 주어지면 `콜론(:)` 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    public void splitAndSum_콜론구분자() {
        int result = StringCalculator.splitAndSum("1:2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("문자열이 주어지면 `쉼표(,)`와 `콜론(:)` 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    public void splitAndSum_쉼표와콜론구분자() {
        int result = StringCalculator.splitAndSum("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("기본 구분자인 `쉼표(,)`, `콜론(:)`외에 커스텀 구분자를 지정할 수 있다.")
    @Test
    public void splitAndSum_커스텀구분자() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("주어진 문자열이 `숫자 이외의 값`을 전달할 경우 `RuntimeException 예외를 throw` 한다.")
    @Test
    void splitAndSum_숫자아님() {
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("잉");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("주어진 문자열이 `음수`를 전달할 경우 `RuntimeException 예외를 throw` 한다.")
    @Test
    void splitAndSum_음수확인() {
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
