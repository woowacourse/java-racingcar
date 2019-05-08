package cal;

import cal.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
    }

    @Test
    void plus() {
        assertThat(cal.plus(2, 3)).isEqualTo(5);
    }

    @Test
    void minus() {
        assertThat(cal.minus(5,3)).isEqualTo(2);
    }


    /* 모든 테스트 케이스는 독립적 + 랜덤실행 */
}
