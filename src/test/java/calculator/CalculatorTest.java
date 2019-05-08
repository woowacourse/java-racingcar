package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup(){
        calculator=new Calculator();
    }


    @Test
    void 마이너스(){
        assertThat(calculator.minus(2,1)).isEqualTo(1);

    }
}
