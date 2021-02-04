package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void splitAndSum_null() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

}