package cal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    @Test
    void setUp() {
    }

    @Test
    void 더하기() {
        //new Operator,('+').calculate()
        //Operator('+')
        assertThat(Operator.ADD.calculate(1, 2)).isEqualTo(3);
        assertThat(Operator.ADD.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        assertThat(Operator.MULTIPLE.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    void 나누기() {
        assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0);
    }

    @Test
    void zero로_나누기() {
        assertThrows(ArithmeticException.class, () -> {
            Operator.DIVIDE.calculate(1, 0);
        });
    }
}
