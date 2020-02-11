package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열 혹은 null 이 입력됐을 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우")
    void splitAndSum_숫자하나() {
        int result = Calculator.splitAndSum("2");
        assertThat(result).isEqualTo(2);
    }

}
