package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.exception.IllegalCustomDelimiterPositionException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5","6:6","7:7","8:8","9:9","0:0"}, delimiter = ':')
    public void splitAndSum_숫자하나(String input, int expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "1,2,3|6", "1:2:3|6", "4,5:6|15"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) throws Exception {
        int result = StringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 입력의 제일 앞이 아니라면 예외")
    @ValueSource(strings = {"3;//;\n1;2;3", "1;2;3//;\n"})
    public void splitAndSum_custom_구분자가_맨_앞이_아니면_예외(String input) {
        assertThatExceptionOfType(IllegalCustomDelimiterPositionException.class)
                .isThrownBy(() -> StringCalculator.splitAndSum(input));
    }

}
