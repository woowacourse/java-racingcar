package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.enums.ErrorMessage;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest(name = "sum() null, empty 테스트 : {0}")
    @NullAndEmptySource
    public void sum_null_and_empty_test(String input) throws Exception {
        int inputResult = Calculator.sum(input);
        assertThat(inputResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "sum() 1개 입력 테스트 : {0}")
    @ValueSource(strings = {"1", "2", "3"})
    public void sum_one_input_test(String input) throws Exception {
        int inputResult = Calculator.sum(input);
        assertThat(inputResult).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "sum() 2개 입력 테스트 : {0}")
    @ValueSource(strings = {"1,2", "2,3", "3,4"})
    public void sum_two_input_test(String input) throws Exception {
        int inputResult = Calculator.sum(input);
        int sum = Arrays.stream(input.split(",|:")).mapToInt(Integer::parseInt).sum();
        assertThat(inputResult).isEqualTo(sum);
    }

    @ParameterizedTest(name = "sum() 임의 구분자 테스트 : {0}")
    @ValueSource(strings = {"//;\n1;2;3", "//!\n1!2!3"})
    public void sum_custom_delimiter_test(String input) throws Exception {
        int inputResult = Calculator.sum(input);
        String delimiter = input.substring(2, 3);
        input = input.substring(4);
        int sum = Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).sum();
        assertThat(inputResult).isEqualTo(sum);
    }

    @ParameterizedTest(name = "sum() 문자 입력 예외 테스트 : {0}")
    @ValueSource(strings = {"a", "a,1", "1,b", "a,b"})
    public void sum_non_number_input_test(String input) throws Exception {
        assertThatThrownBy(() -> Calculator.sum(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorMessage.NONE_INTEGER_ERROR_MESSAGE.get());
    }

    @ParameterizedTest(name = "sum() 음수 입력 예외 테스트 : {0}")
    @ValueSource(strings = {"-1", "-1,1", "1,-1", "-1,-2"})
    public void sum_negative_input_test(String input) throws Exception {
        assertThatThrownBy(() -> Calculator.sum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_VALUE_ERROR_MESSAGE.get());
    }
}
