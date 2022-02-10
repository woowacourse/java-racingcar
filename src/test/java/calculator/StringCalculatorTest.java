package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

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
}