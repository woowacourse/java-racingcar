package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_empty() {
        int result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_single_number() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_comma_delimiter() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_comma_or_colon_delimiter() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_delimiter() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
