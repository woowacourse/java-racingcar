package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    
    @DisplayName("splitAndSum에 null 혹은 빈문자가 왔을 때")
    @Test
    void splitAndSum_nullOrEmpty_convertToZero() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("splitAndSum에 숫자 하나가 왔을 때")
    @Test
    void splitAndSum_inputWithoutDelimiter_returnSameNumberAsInput() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("splitAndSum에 쉼표 또는 콜론 구분자가 올 때")
    @Test
    void splitAndSum_inputWithCommaAndColon_splitInputAndReturnSum() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum에 쉼표구분자가 올 때")
    @Test
    void splitAndSum_inputWithComma_splitInputAndReturnSum() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("splitAndSum에 custom 구분자가 올 때")
    @Test
    void splitAndSum_inputWithCustomDelimiter_splitInputAndReturnSum() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum에 음수가 들어올 때")
    @Test
    void splitAndSum_negativeNumberInput_ThrowException() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
