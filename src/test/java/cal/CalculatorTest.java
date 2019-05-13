package cal;

import cal.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new Calculator();
        System.out.println("Setup");
    }

    @Test
    void 덧셈() {
        assertThat(cal.add(2, 3)).isEqualTo(5);
        System.out.println("plus");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.delete(5,2)).isEqualTo(3);
        System.out.println("minus");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }

}
