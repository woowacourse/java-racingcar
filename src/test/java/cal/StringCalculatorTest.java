package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new StringCalculator();
    }

    @Test
    void 연산자매칭() {
        assertThat(cal.matchCalculate(20, "/", 5)).isEqualTo(4);
        assertThat(cal.matchCalculate(5, "-", 3)).isEqualTo(2);
    }

    @Test
    void 문자열계산기() {
        assertThat(cal.calculate(cal.splitStringBySpace("2 + 3 * 4 / 2"))).isEqualTo(10);
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
}
