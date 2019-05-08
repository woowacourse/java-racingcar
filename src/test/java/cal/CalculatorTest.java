package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void addTest() {
        Calculator cal = new Calculator();
        int result = cal.plus(2, 3);
        // System.out.println(result);
        assertThat(result).isEqualTo(5);
    }
}
