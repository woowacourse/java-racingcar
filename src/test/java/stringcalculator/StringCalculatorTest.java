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
    @DisplayName("입력 문자열이 null 또는 빈 문자열인지 검사")
    @Test
    void isNullOrEmpty() {
        assertThat(StringCalculator.isNullOrEmpty(null)).isTrue();
        assertThat(StringCalculator.isNullOrEmpty("")).isTrue();
        assertThat(StringCalculator.isNullOrEmpty("abc")).isFalse();
    }

    @DisplayName("입력 문자열 포맷 검사 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"", "1:2:3", "1,2,3", "//;\n", "//;\n1;2;3", "//_\n1_2_3"})
    void validateInputSuccess(String text) {
        Assertions.assertDoesNotThrow(() -> StringCalculator.validateInput(text));
    }

    @DisplayName("입력 문자열 포맷 검사 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:", ",2,3", "//;\n;", "//;\n1;2;", "/:\n", "///;\n1;2", "1::2", ";;;"})
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
    @Test
    void getDelimiterFromText() {
        assertThat(StringCalculator.getDelimiterFromText("//;\n1;2;3")).isEqualTo(";");
        assertThat(StringCalculator.getDelimiterFromText("//_\n1_2_3")).isEqualTo("_");
        assertThat(StringCalculator.getDelimiterFromText("//-\n1-2-3")).isEqualTo("-");
    }

    @DisplayName("문자열에서 구분자 제거")
    @Test
    void removeDelimiterFromText() {
        assertThat(StringCalculator.removeDelimiterFromText("//;\n1;2;3")).isEqualTo("1;2;3");
        assertThat(StringCalculator.removeDelimiterFromText("//_\n1_2_3")).isEqualTo("1_2_3");
        assertThat(StringCalculator.removeDelimiterFromText("//-\n1-2-3")).isEqualTo("1-2-3");
    }

    @DisplayName("String 배열을 Int 로 형변환")
    @Test
    void toIntegerArray() {
        assertThat(StringCalculator.toIntegerArray(new String[]{"0", "1", "2", "3"}))
                .containsExactly(0, 1, 2, 3);
    }

    @DisplayName("숫자 배열의 합 계산")
    @Test
    void sumIntegerArray() {
        assertThat(StringCalculator.sumIntegerArray(new Integer[]{1, 2, 3}))
                .isEqualTo(6);

        assertThat(StringCalculator.sumIntegerArray(new Integer[]{0, 0, 0}))
                .isEqualTo(0);

        assertThat(StringCalculator.sumIntegerArray(new Integer[]{00, 100, 1000}))
                .isEqualTo(1100);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        int result = StringCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}

