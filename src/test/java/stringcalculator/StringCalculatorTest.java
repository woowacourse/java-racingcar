package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {
    @Test
    public void splitAndSum_null() {
        int result = StringCalculator.caculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_빈문자() {
        int result = StringCalculator.caculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringCalculator.caculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringCalculator.caculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringCalculator.caculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringCalculator.caculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.caculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_문자() {
        assertThatThrownBy(() -> StringCalculator.caculate("test"))
                .isInstanceOf(RuntimeException.class);
    }
}