package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> stringCalculator.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("쉼표, 콜론 구분자로 분리")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void splitString(String input) {
        assertThat(stringCalculator.split(input)).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자로 분리")
    @ParameterizedTest
    @CsvSource(value = {"1;2;3,;", "1_2_3,_", "1-2-3,-"})
    void splitStringWithCustomDelimiter(String input, String delimiter) {
        assertThat(stringCalculator.split(input, delimiter)).containsExactly("1", "2", "3");
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource(value = {"a,false,0", "-1,false,0", "1,true,1", "0,true,0"})
    void toNumber(String text, boolean isSucceed, int expected) {
        if (isSucceed) {
            assertThat(stringCalculator.toNumber(text)).isEqualTo(expected);
        }

        if (!isSucceed) {
            assertThatThrownBy(() -> stringCalculator.toNumber(text))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("올바른 숫자가 아닙니다.");
        }
    }

    @DisplayName("구분된 문자열을 숫자로 변환 - 성공")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    void successToNumber(String text, int expected) {
        assertThat(stringCalculator.toNumber(text)).isEqualTo(expected);
    }

    @DisplayName("구분된 문자열을 숫자로 변환 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void failToNumber(String text) {
        assertThatThrownBy(() -> stringCalculator.toNumber(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력 하셔야합니다.");
    }

    @DisplayName("커스텀 구분자가 포함된 형태인지 검사")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3|false", "1:2:3|false", "//;\\n1;2;3|true", "//_\\n1_2_3|true"}, delimiter = '|')
    void hasCustomDelimiter(String text, boolean expected) {
        assertThat(stringCalculator.hasCustomDelimiter(text)).isEqualTo(expected);
    }

    @DisplayName("구분자 파싱")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n,;", "//_\\n,_", "//-\\n,-"})
    void getDelimiterFromText(String text, String expected) {
        assertThat(stringCalculator.getDelimiterFromText(text)).isEqualTo(expected);
    }

    @DisplayName("문자열에서 구분자 제거")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3,1;2;3", "//_\\n1_2_3,1_2_3", "//-\\n1-2-3,1-2-3"})
    void removeDelimiterFromText(String text, String expected) {
        assertThat(stringCalculator.removeDelimiterFromText(text)).isEqualTo(expected);
    }
}
