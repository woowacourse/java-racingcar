import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp() {
        cal = new Calculator();
    }

    @Test
    void addTest() {
        assertThat(cal.addition(1,2)).isEqualTo(3);
    }

    @Test
    void subTest() {
        assertThat(cal.subtraction(2,2)).isEqualTo(0);
    }
}
