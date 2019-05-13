package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumericExpressionTest {

    @Test
    void 숫자연산자혼합인지확인() {
        String[] array = "3 + 2 * 4".split(" ");
        assertThat(InputHandler.canCalculate(array)).isEqualTo(true);
    }

    @Test
    void 연산자로끝나는식() {
        String[] array = "3 + 2 *".split(" ");
        assertThat(InputHandler.canCalculate(array)).isEqualTo(false);
    }
}
