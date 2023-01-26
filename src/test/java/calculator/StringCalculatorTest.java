package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        int nullInputResult = StringCalculator.splitAndSum(null);
        int emptyInputResult = StringCalculator.splitAndSum("");
        assertAll(
            () -> assertThat(nullInputResult).isEqualTo(0),
            () -> assertThat(emptyInputResult).isEqualTo(0)
        );
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_숫자_이외의_값_전달() throws Exception {
        assertAll(
            () -> assertThatThrownBy(() -> StringCalculator.splitAndSum("1,@,3"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> StringCalculator.splitAndSum("1,A,3"))
                .isInstanceOf(RuntimeException.class)
        );
    }
}