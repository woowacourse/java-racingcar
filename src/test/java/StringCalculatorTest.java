import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void calculate() {
        String value = "1,2:3";
        assertThat(StringCalculator.run(value)).isEqualTo(6);

        value = "1:6,3";
        assertThat(StringCalculator.run(value)).isEqualTo(10);

        value = "";
        assertThat(StringCalculator.run(value)).isEqualTo(0);

        value = null;
        assertThat(StringCalculator.run(value)).isEqualTo(0);
    }
}

