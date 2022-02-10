package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @DisplayName("입력 문자열 포맷 검사 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"", "1:2:3", "1,2,3", "//;\\n", "//;\\n1;2;3", "//_\\n1_2_3"})
    void validateInputSuccess(String text) {
        Assertions.assertDoesNotThrow(() -> StringCalculator.validateInput(text));
    }

    @DisplayName("입력 문자열 포맷 검사 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:", ",2,3", "//;\\n;", "//;\\n1;2;", "/:\\n", "///;\\n1;2", "1::2", ";;;"})
    void validateInputFail(String text) {
        assertThatThrownBy(() -> StringCalculator.validateInput(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("잘못된 입력 형식입니다.");
    }

    @DisplayName("커스텀 구분자로 분리")
    @ParameterizedTest
    @CsvSource(value = {"1;2;3|;", "1_2_3|_", "1-2-3|-"}, delimiter = '|')
    void splitStringWithCustomDelimiter(String input, String delimiter) {
        assertThat(StringCalculator.split(input, delimiter)).containsExactly("1", "2", "3");
    }

    @DisplayName("구분된 문자열을 숫자로 변환")
    @ParameterizedTest
    @CsvSource(value = {"0|0", "1|1", "2|2", "3|3"}, delimiter = '|')
    void toNumber(String text, int expected) {
        assertThat(StringCalculator.toNumber(text)).isEqualTo(expected);
    }

    @DisplayName("음수인지 검사 - 성공")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void validateNegativeNumberSuccess(int number) {
        Assertions.assertDoesNotThrow(() -> StringCalculator.validateNegativeNumber(number));
    }

    @DisplayName("음수인지 검사 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void validateNegativeNumberFail(int number) {
        assertThatThrownBy(() -> StringCalculator.validateNegativeNumber(number))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @DisplayName("구분자 파싱")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3|;", "//_\\n1_2_3|_", "//-\\n1-2-3|-"}, delimiter = '|')
    void getDelimiterFromText(String text, String expected) {
        assertThat(StringCalculator.getDelimiterFromText(text)).isEqualTo(expected);
    }

    @DisplayName("문자열에서 구분자 제거")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3|1;2;3", "//_\\n1_2_3|1_2_3", "//-\\n1-2-3|1-2-3"}, delimiter = '|')
    void removeDelimiterFromText(String text, String expected) {
        assertThat(StringCalculator.removeDelimiterFromText(text)).isEqualTo(expected);
    }

    @DisplayName("입력된 문자열의 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3|6", "//;\\n1;2;3|6"}, delimiter = '|')
    void sum(String text, int expected) {
        assertThat(StringCalculator.sum(text)).isEqualTo(expected);
    }

    @DisplayName("String 배열을 Int 로 형변환")
    @Test
    void toIntArray() {
        assertThat(StringCalculator.toIntegerArray(new String[]{"0", "1", "2", "3"}))
                .containsExactly(0, 1, 2, 3);
    }
}

