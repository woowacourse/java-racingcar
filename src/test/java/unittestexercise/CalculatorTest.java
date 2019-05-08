package unittestexercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
        System.out.println("Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After\n");
    }

    @Test
    void plus() {
        int result = cal.plus(1, 2);
        assertThat(result).isEqualTo(3);
        System.out.println("Plus");
    }

    @Test
    void minus() {
        assertThat(cal.minus(10, 3)).isEqualTo(7);
        System.out.println("Minus");
    }
}
