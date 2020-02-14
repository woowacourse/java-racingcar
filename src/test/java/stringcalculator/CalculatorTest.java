package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private static Stream<Arguments> sourceForNegativeException() {
        return Stream.of(
                Arguments.of("1,2:-3", -3),
                Arguments.of("//;\n1;2;-5", -5)
        );
    }

    @DisplayName("커스텀 문자열 계산 테스트")
    @Test
    void customPlusTest() {
        assertThat(Calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("디폴트 문자열 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    void plusTest(String input, int result) {
        assertThat(Calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("문자열 중에 음수가 포함되어있으면 예외가 발생하는지 테스트")
    @ParameterizedTest
    @MethodSource("sourceForNegativeException")
    void inputNegativeThrowIllegalException(String input, int negative) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%d는 음수입니다.", negative);
    }

    @DisplayName("null이나 공백을 입력했을때 0이 반환되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {",0", "'',0"})
    public void nullOrEmptyCalculateTest() {
        int result = Calculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력했을때 그 숫자가 반환되는지 테스트")
    @Test
    public void 숫자하나() throws Exception {
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자로 입력했을때 잘 계산되는지 테스트")
    @Test
    public void 쉼표구분자() throws Exception {
        int result = Calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자로 입력했을때 잘 계산되는지 테스트")
    @Test
    public void 쉼표_또는_콜론_구분자() throws Exception {
        int result = Calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 잘 계산되는지 테스트")
    @Test
    public void custom_구분자() throws Exception {
        int result = Calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 포함되어 있을때 예외가 발생하는지 테스트")
    @Test
    public void negative() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
