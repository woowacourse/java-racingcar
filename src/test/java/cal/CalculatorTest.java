package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
    }

    @Test
    void addTest() {
        assertThat(cal.plus(2,3)).isEqualTo(5);
    }

    @Test
    void minusTest() {
        assertThat(cal.minus(2, 3)).isEqualTo(-1);
    }

    @Test
    void mulTest() {
        assertThat(cal.mul(4, 2)).isEqualTo(8);
    }

    @Test
    void divTest() {
        assertThat(cal.div(4, 2)).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
        cal = null;
    }
}
