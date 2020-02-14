package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * 클래스 이름 : CalculatorTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.11 화요일
 */

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열 혹은 null 이 입력됐을 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "11:11"}, delimiter = ':')
    @DisplayName("숫자 하나를 문자열로 입력할 경우")
    void splitAndSum_숫자하나(String input, int answer) {
        int result = Calculator.splitAndSum(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "2,4:6", "3,3,7:13"}, delimiter = ':')
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 합 반환")
    void splitAndSum_쉼표구분자(String input, int answer) {
        int result = Calculator.splitAndSum(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:4;6", "1:2,3;6", "3,3:7;13"}, delimiter = ';')
    @DisplayName("구분자를 컴마 이외의 콜론을 사용할 경우 합 반환")
    void splitAndSum_쉼표_혹은_콜론_구분자(String input, int answer) {
        int result = Calculator.splitAndSum(input);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있음")
    void splitAndSum_custom_구분자() {
        int result = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("지정된 구분자가 아닌 문자가 들어왔을 경우 예외 발생하게 됨")
    void splitAndSum_지정되지_않은_구분자() {
        assertThatThrownBy(() -> {
            int result = Calculator.splitAndSum("1:2@3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자와 구분자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생하게 됨")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> {
            int result = Calculator.splitAndSum("1,2,-3");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 포함할 수 없습니다.");

        assertThatThrownBy(() -> {
            int result = Calculator.splitAndSum("//;\n1;-2;3");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("문자열을 전달할 경우 예외가 발생하게 됨")
    void splitAndSum_문자열() {
        assertThatThrownBy(() -> {
            int result = Calculator.splitAndSum("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자와 구분자만 입력할 수 있습니다.");
    }
}
