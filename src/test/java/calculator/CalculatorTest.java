package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 덧셈() {
        String input = "1,2:3,4";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 숫자_이외의값_혹은_음수_입력() {
        String exceptNumberInputs = "ㅋㅋ:-222,3333";
        assertThatThrownBy(() -> {
            Calculator.calculate(exceptNumberInputs);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자만_들어왔을때() {
        String input = "123";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(123);
    }
}
