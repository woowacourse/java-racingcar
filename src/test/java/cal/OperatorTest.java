package cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    int num1;
    int num2;
    char operator;

    @BeforeEach
    void setUp() {
        num1 = 2;
        num2 = 3;
    }

    @Test
    void 더하기() {
        operator = '+';
        assertThat(Operator.fromName(operator).calculate(num1, num2)).isEqualTo(5);
        System.out.println("10");
    }

    @Test
    void 뺴기() {
        operator = '-';
        assertThat(Operator.fromName(operator).calculate(num1, num2)).isEqualTo(-1);
        System.out.println("10");
    }

    @Test
    void 곱하기() {
        operator = '*';
        assertThat(Operator.fromName(operator).calculate(num1, num2)).isEqualTo(6);
        System.out.println("10");
    }

    @Test
    void 나누기() {
        operator = '/';
        assertThat(Operator.fromName(operator).calculate(num1, num2)).isEqualTo(0);
        System.out.println("10");
    }

    @Test
    void 영으로_나눌떄_예외() {
        num2 = 0;
        operator = '/';
        assertThrows(IllegalArgumentException.class, () -> {
            Operator.fromName(operator).calculate(num1, num2);
        });
    }
}
