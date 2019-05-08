package cal;

import cal.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp(){
        cal = new Calculator();
        System.out.println("setUp");
    }

    @Test
    void 덧셈() {
        assertThat(cal.add(2,3)).isEqualTo(5);
        System.out.println("plus");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.sub(3,2)).isEqualTo(1);
        System.out.println("minus");
    }

    @Test
    void 곱셈() {
        assertThat(cal.mul(2,3)).isEqualTo(6);
        System.out.println("multiple");
    }

    @Test
    void 나눗셈() {
        assertThat(cal.div(6,2)).isEqualTo(3);
        System.out.println("divide");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("계산 끝");
        cal = null;
    }
}
