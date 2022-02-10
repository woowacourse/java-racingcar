package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 입력시 0 반환 테스트")
    public void splitAndSum_null_or_empty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력시 변환 후 반환 테스트")
    void splitAndSum_singleNumber() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }
}
