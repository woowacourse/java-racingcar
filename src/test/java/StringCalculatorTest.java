import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.calculate("5 - 4")).isEqualTo(1);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.calculate("4 / 2")).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(cal.calculate("2 * 3")).isEqualTo(6);
    }

    @AfterEach
    void tearDown() {
        cal = null;
    }
}
