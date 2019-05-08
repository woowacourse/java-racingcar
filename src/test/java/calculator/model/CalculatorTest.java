package calculator.model;

import calculator.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    @Test
    void 플러스(){
        assertThat(Calculator.plus(1,2)).isEqualTo(3);
        assertThat(Calculator.plus(-5,2)).isEqualTo(-3);
    }

    @Test
    void 마이너스(){
        assertThat(Calculator.minus(2,1)).isEqualTo(1);
    }

    @Test
    void 곱하기(){
        assertThat(Calculator.multiply(1,2)).isEqualTo(2);
        assertThat(Calculator.multiply(1,0)).isEqualTo(0);
    }

    @Test
    void 나누기(){
        assertThat(Calculator.divide(10,2)).isEqualTo(5);
        assertThat(Calculator.divide(9,2)).isEqualTo(4.5);
    }
}
