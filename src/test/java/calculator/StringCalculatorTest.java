package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 덧셈() {
        int result = StringCalculator.plusByDelimiterFrom("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 덧셈세개() {
        int result = StringCalculator.plusByDelimiterFrom("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈커스텀() {
        int result = StringCalculator.plusByDelimiterFrom("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void split학습테스트() {
        String[] values = "1,2:3,4:5".split(",|:");
        assertThat(values.length).isEqualTo(5);
    }
}
