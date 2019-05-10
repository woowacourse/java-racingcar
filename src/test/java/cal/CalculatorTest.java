package cal;

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
        assertThat(cal.add(2, 3)).isEqualTo(5);
        System.out.println("Play plus");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.sub(3, 2)).isEqualTo(1);
        System.out.println("Play minus");
    }

    @Test
    void 곱셈() {
        assertThat(cal.mul(2, 3)).isEqualTo(6);
        System.out.println("Play multiple");
    }

    @Test
    void 나눗셈() {
        assertThat(cal.div(6, 2)).isEqualTo(3);
        System.out.println("Play divide");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Bye I'm Done");
        cal = null;
    }
}
