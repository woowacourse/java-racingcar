package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    @DisplayName("null 입력 시 예외")
    void inputNullException() {
        int number = Application.runCalculator(null);

        assertThat(number).isEqualTo(0);
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 시 예외")
    void inputEmptyException() {
        int number = Application.runCalculator("");

        assertThat(number).isEqualTo(0);
    }

    @Test
    @DisplayName("공백 입력 시 예외")
    void inputBlankException() {
        int number = Application.runCalculator(" ");

        assertThat(number).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 기준으로 나누어서 연산")
    void calculateByDelimiter() {
        int number = Application.runCalculator("1,2");

        assertThat(number).isEqualTo(3);

        number = Application.runCalculator("1:2");

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 하나 입력 시")
    void inputOneNumber() {
        int number = Application.runCalculator("1");

        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("커스텀 구분자 기준 연산")
    void calculateByCustomDelimiter() {
        int number = Application.runCalculator("//;\n12;2;3");

        assertThat(number).isEqualTo(17);
    }

    @Test
    @DisplayName("음수 입력 시 예외")
    void inputNegativeNumberException() {
        assertThatThrownBy(() -> Application.runCalculator("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 예외")
    void inputStringException() {
        assertThatThrownBy(() -> Application.runCalculator("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}