import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
    }

    @Test
    void testAdd() {
        assertThat(cal.add(2, 5)).isEqualTo(7);
        assertThat(cal.add(2, 5)).isEqualTo(3);
    }

    @Test
    void testSubtract() {
        assertThat(cal.subtract(5, 2)).isEqualTo(3);
        assertThat(cal.subtract(2, 5)).isEqualTo(-3);
    }

    @Test
    void testMultiply() {
        assertThat(cal.multiply(5, 2)).isEqualTo(10);
        assertThat(cal.multiply(5, 0)).isEqualTo(0);
        assertThat(cal.multiply(5, -3)).isEqualTo(-15);
    }

    @Test
    void testDivide() {
        assertThat(cal.divide(10, 5)).isEqualTo(2);
        assertThat(cal.divide(10, 3)).isEqualTo(3);
        assertThat(cal.divide(10, -3)).isEqualTo(-3);
    }

    @Test
    void testMod() {
        assertThat(cal.mod(10, 5)).isEqualTo(0);
        assertThat(cal.mod(10, 3)).isEqualTo(1);
        assertThat(cal.mod(10, -3)).isEqualTo(1);
    }
}
