package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 음수_예외처리() {
        assertThatThrownBy(()-> StringCalculator.plusByDelimiterFrom("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 비어있는_문자열_null_전달시_예외() {
        assertThatThrownBy(() -> StringCalculator.plusByDelimiterFrom(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> StringCalculator.plusByDelimiterFrom(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
