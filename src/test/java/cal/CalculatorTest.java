package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new Calculator();
    }

    @Test
    void 덧셈() {
        assertThat(cal.plus(2,3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(cal.minus(2,3)).isEqualTo(-1);
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
}
