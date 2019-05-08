package Exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorExceptionTest {
    @Test
    void isNotAllNumberTest(){
        String data = "2 + 3 + t";
        assertThat(CalculatorException.isNotAllNumber(data)).isEqualTo(false);
    }
}
