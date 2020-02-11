package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 구분자가_쉼표인_경우_분리() {
        String[] result = Calculator.splitString("1,2,3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }
}
