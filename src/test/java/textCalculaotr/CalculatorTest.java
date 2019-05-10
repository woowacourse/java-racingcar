import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;
            
    @BeforeEach
    void setUp() {
        cal = new Calculator();
        System.out.println("Setup");
    }

    @Test
    void 덧셈() {
        // System.out.println(result); 가능한 하지 말아야 할 행동
        assertThat(cal.add(2, 3)).isEqualTo(5);
        System.out.println("Plus");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.subtract(3, 2)).isEqualTo(1);
        System.out.println("Minus");
    }

    @Test
    void 곱셈() {
        assertThat(cal.multiply(2, 3)).isEqualTo(6);
        System.out.println("Multiple");
    }

    @Test
    void 나눗셈() {
        assertThat(cal.division(3, 2)).isEqualTo(1);
        System.out.println("Divide");
    }

    @AfterEach
    void tearDown() {
        System.out.println("teardown");
    }
}