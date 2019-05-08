package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class CalculatorTest {
    Calculator cal ;

    // 모든 테스트케이스는 독립적으로 서로 의존되면 안됨.


    @BeforeEach
    void setUp() {
        cal = new Calculator();
        System.out.println();
    }

    @Test
    void 덧셈() {
//        Calculator calculator = new Calculator();
//        int result = calculator.plus(3,2);
//        assertThat(result).isEqualTo(5);
        assertThat(cal.plus(2,3)).isEqualTo(5);
        System.out.println("PLUS");

    }

    @Test
    void 뺄셈() {
        assertThat(cal.plus(2,3)).isEqualTo(-1);
        System.out.println("Minus");
    }

    @AfterEach
    void testDown() {
        System.out.println("Testdown");
    }
}