package calculator;

import static org.assertj.core.api.Assertions.*;
import calcaulator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값일 경우 0을 반환한다")
    void addStringTest(String text) {
        StringCalculator.addString(text);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환하다")
    void inputParameterIsOne(String value, int expected) {
        assertThat(StringCalculator.addString(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    @DisplayName("숫자 두 개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void addTwoNumbersUsingComma(String text, int expected) {
        assertThat(StringCalculator.addString(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2;3", "3:4;7"}, delimiter = ';')
    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다")
    void addTwoNumbersUsingColon(String text, int expected) {
        assertThat(StringCalculator.addString(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//-\\n1-2;3", "//-\\n3-4;7"}, delimiter = ';')
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void addTwoNumbersUsingCustomDelimiter(String text, int expected) {
        assertThat(StringCalculator.addString(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:-2", "-3:4"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void throwRuntimeExceptionWhenMinus(String text) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringCalculator.addString(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"s", "h,1,1", "1,2,k"})
    @DisplayName("숫자가 아닌경우 RuntimeException 발생해야 한다")
    void throwRuntimeExceptionWhenNotNumber(String text) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringCalculator.addString(text))
            .withMessageContaining("올바른 숫자를 입력해주세요.");
    }
}
