package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> StringCalculator.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("커스텀 구분자로 분리")
    @ParameterizedTest
    @CsvSource(value = {"1;2;3|;", "1_2_3|_", "1-2-3|-"}, delimiter = '|')
    void splitStringWithCustomDelimiter(String input, String delimiter) {
        assertThat(StringCalculator.split(input, delimiter)).containsExactly("1", "2", "3");
    }

    @DisplayName("구분된 문자열을 숫자로 변환 - 성공")
    @ParameterizedTest
    @CsvSource(value = {"0|0", "1|1", "2|2", "3|3"}, delimiter = '|')
    void toNumberSuccess(String text, int expected) {
        assertThat(StringCalculator.toNumber(text)).isEqualTo(expected);
    }

    @DisplayName("구분된 문자열을 숫자로 변환 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "-1"})
    void toNumberFail(String text) {
        assertThatThrownBy(() -> StringCalculator.toNumber(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("올바른 숫자가 아닙니다.");
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
}
