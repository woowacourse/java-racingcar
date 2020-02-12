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
    public void splitAndSumOneNumberTest() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표구분자로 문자열을 나눠서 숫자들의 합을 출력 테스트")
    @Test
    public void splitAndSumUsingCommaDelimiterTest() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자를 이용해 문자열을 나눠서 숫자들의 합을 출력 테스트")
    @Test
    public void splitAndSumUsingCommaOrColonDelimiterTest() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        Assertions.assertThat(result).isEqualTo(6);
    }
}
