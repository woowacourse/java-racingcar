package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_custom_구분자_또는_기본_구분_두개_이상() {
        int result = StringCalculator.calculate("//!!\n1!!2!!3,4:5");
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void splitAndSum_custom_구분자_또는_기본_구분자() {
        assertThatThrownBy(() -> {
            int result = StringCalculator.calculate("//-\n1-2-5--3-4");
            assertThat(result).isEqualTo(15);
        }).isInstanceOf(RuntimeException.class);
    }
}