package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void splitAndSum_null() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_빈문자() {
        int result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}