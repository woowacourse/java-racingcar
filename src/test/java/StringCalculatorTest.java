import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void calculate() {
        String value = "1,2:3";
        assertThat(StringCalculator.run(value)).isEqualTo(6);

        String value2 = "1:6,3";
        assertThat(StringCalculator.run(value2)).isEqualTo(10);
    }
}

