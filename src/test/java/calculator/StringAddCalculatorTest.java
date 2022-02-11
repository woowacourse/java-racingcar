package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringAddCalculatorTest {
    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환해야 한다.")
    void nullString() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
    void emptyString() {
        String emptyString = "";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum(emptyString)).isEqualTo(0);
    }


    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumber() {
        String oneString = "1";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.splitAndSum(oneString);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void commaSplit() {
        String stringWithComma = "1,2";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.splitAndSum(stringWithComma);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void colonSplit() {
        String stringWithCommaAndColon = "1,2:3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.splitAndSum(stringWithCommaAndColon);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void customDelimiterSplit() {
        String stringWithCustomDelimiter = "//;\n1;2;3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.splitAndSum(stringWithCustomDelimiter);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void negativeNumberError() {
        String negativeNumberString = "-1,2,3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum(negativeNumberString);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void notNumberError() {
        String notNumberString = "1,a,3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum(notNumberString);
        }).isInstanceOf(RuntimeException.class);
    }
}