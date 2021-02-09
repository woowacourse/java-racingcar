package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @DisplayName("1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    @Test
    void splitAndSumNullOrEmptyString() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    @Test
    void splitAndSumOneNumber() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    @Test
    void splitAndSumTwoNumbersWithCommaDelimiter() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    @Test
    void splitAndSumNumbersWithCommaOrColonDelimiter() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("5. “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    @Test
    void splitAndSumWithCustomDelimiter() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    @Test
    void splitAndSumNegativeNumberRuntimeException() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}