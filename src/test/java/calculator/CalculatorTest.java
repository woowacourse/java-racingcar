package calculator;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
        System.out.println("setup");
    }

    @Test
    void 덧셈() {
//        calculator.Calculator cal = new calculator.Calculator();    // BeforEach의 setUp 함수로 반복을 없앰.
//        int result = cal.add(2,3);
//        System.out.println(result);           // assertThat 함수로 대신.
        AssertionsForClassTypes.assertThat(cal.add(2,3)).isEqualTo(5);
        System.out.println("덧셈");
    }

    @Test
    void 뺄셈() {
//        calculator.Calculator cal = new calculator.Calculator();
//        int result = cal.subtract(2,3);
        AssertionsForClassTypes.assertThat(cal.subtract(2,3)).isEqualTo(-1);
        System.out.println("뺄셈");
    }

    @AfterEach
    void tearDown() {
        cal = null;
        System.out.println("tearDown");
    }
}
