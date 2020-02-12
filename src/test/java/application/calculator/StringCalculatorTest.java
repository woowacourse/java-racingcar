package application.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @DisplayName("null 또는 빈 문자열 계산 시 0을 결과로 출력 테스트")
    @Test
    public void splitAndSumNullOrEmptyStringTest() {
        int result = StringCalculator.splitAndSum(null);
        Assertions.assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력 시 그 숫자 그대로 출력 테스트")
    @Test
    public void splitAndSumOneNumberTest() {
        int result = StringCalculator.splitAndSum("1");
        Assertions.assertThat(result).isEqualTo(1);
    }
}
