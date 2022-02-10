package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringAddCalculatorTest {
    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void emptyStringTest() {
        String emptyString = "";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.run(emptyString);
        int nullResult = stringAddCalculator.run(null);
        assertThat(result).isEqualTo(0);
        assertThat(nullResult).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumberTest() {
        String oneString = "1";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.run(oneString);
        assertThat(result).isEqualTo(1);
    }
}