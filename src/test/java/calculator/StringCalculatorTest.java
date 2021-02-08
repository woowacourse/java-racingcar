package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("null 또는 빈문자 입력 테스트")
    @Test
    public void nullOrEmptyInput() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("단일 숫자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "23", "24", "6"})
    public void onlyNumberInput(String input) {
        int result = StringCalculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("쉼표로 구분된 입력 문자열 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,3,4,4 : 12", "12,3,2,4 : 21"}, delimiter = ':')
    public void splitWithSingleSeparator(String inputLine, int expectSum) {
        int result = StringCalculator.calculate(inputLine);
        assertThat(result).isEqualTo(expectSum);
    }

    @DisplayName("쉼표 또는 클론으로 구분된 입력 문자열 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,3,4,4 : 12", "12,3,2,4 : 21"}, delimiter = ':')
    public void splitWithMultipleSeparator(String inputLine, int expectSum) {
        int result = StringCalculator.calculate(inputLine);
        assertThat(result).isEqualTo(expectSum);
    }

    @DisplayName("커스텀 구분자로 구분된 입력 문자열 계산 테스트 ")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void splitWithCustomSeparator(String inputLine) {
        int result = StringCalculator.calculate(inputLine);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 절달될 경우 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;-2;3", "-1,1,3"})
    public void splitAndSum_negative(String inputLine) {
        assertThatThrownBy(() -> StringCalculator.calculate(inputLine))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("커스텀 구분자가 두 글자 이상인 경우의 문자열 계산")
    @ParameterizedTest
    @ValueSource(strings = {"//!!\n1!!2!!3,4:5"})
    public void splitWithMoreThanTwoChar(String inputLine) {
        int result = StringCalculator.calculate(inputLine);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("-가 커스텀 구분자로 포함되는 경우 음수 판별 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//-\n1-2-5--3-4"})
    public void splitWithDash(String inputLine) {
        assertThatThrownBy(() -> {
            int result = StringCalculator.calculate(inputLine);
            assertThat(result).isEqualTo(15);
        }).isInstanceOf(RuntimeException.class);
    }
}