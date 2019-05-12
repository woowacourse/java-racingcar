package cal.normal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator cal;
    @BeforeEach
    void setup() {
        cal = new Calculator();
        System.out.println("Hi I'm Setup");
    }

    @Test
    void 덧셈() {
        assertThat(cal.plus(1, 2)).isEqualTo(3);
        System.out.println("덧셈이야");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.subtract(1, 5)).isEqualTo(-4);
        System.out.println("뺄셈이야");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Bye");
    }
}