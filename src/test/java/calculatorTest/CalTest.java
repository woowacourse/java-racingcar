package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalTest {
    @Test
    @DisplayName("빈 문자열 혹은 null 이 입력됐을 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}
