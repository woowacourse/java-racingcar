package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void 덧셈() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }
}