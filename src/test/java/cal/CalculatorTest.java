package cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @BeforeEach
    void setup() {
        Calculator cal = new Calculator();
    }

    @Test
    void addTest() {
        // Calculator cal = new Calculator();
        // int result = cal.plus(2, 3);
        // System.out.println(result);
        assertThat(cal.plus(2,3)).isEqualTo(5);
    }

    @Test
    void minusTest() {
        // Calculator cal = new Calculator();
        // int result = cal.minus(2, 3);
        assertThat(cal.minus(2,3)).isEqualTo(-1);
    }
}
