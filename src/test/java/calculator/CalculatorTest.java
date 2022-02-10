package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}
