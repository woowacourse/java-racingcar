package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("sum() null 값이 입력되었을 때 테스트")
    @Test
    public void sum_null_test() throws Exception {
        int inputResult = Calculator.sum(null);
        assertThat(inputResult).isEqualTo(0);
    }

    @DisplayName("sum() 빈칸이 입력되었을 때 테스트")
    @Test
    public void sum_empty_test() throws Exception {
        int inputResult = Calculator.sum("");
        assertThat(inputResult).isEqualTo(0);
    }

    @DisplayName("sum() 입력 값이 하나인 경우 테스트")
    @Test
    public void sum_with_only_one_test() throws Exception {
        int inputResult = Calculator.sum("3");
        assertThat(inputResult).isEqualTo(3);
    }

    @DisplayName("sum() 사용자 임의의 구분자를 이용한 테스트")
    @Test
    public void sum_custom_delimiter_test() throws Exception {
        int inputResult = Calculator.sum("//;\n1;2;3");
        assertThat(inputResult).isEqualTo(6);
    }

    @DisplayName("sum() 입력 값이 문자인 경우 예외 테스트")
    @Test
    public void sum_nonNumber_test() throws Exception {
        assertThatThrownBy(() -> Calculator.sum("a,b"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("sum() 음수를 입력 했을 때 예외 테스트")
    @Test
    public void sum_negativeNumber_test() throws Exception {
        assertThatThrownBy(() -> Calculator.sum("-1,-2"))
                .isInstanceOf(RuntimeException.class);
    }
}
