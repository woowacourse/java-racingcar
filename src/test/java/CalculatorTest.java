import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void add() {
        int result = StringCalculator.add("1 + 2");
        assertThat(result).isEqualTo(3);
    }
}
