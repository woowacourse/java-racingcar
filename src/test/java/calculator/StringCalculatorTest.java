package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 덧셈() {
        int result = StringCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 덧셈세개() {
        int result = StringCalculator.calculate("1,2,3");
        assertThat(result).isEqualTo(6);
    }

}
