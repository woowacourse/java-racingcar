package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void beforeEach() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null값_입력(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void 숫자_하나만_입력() {
        assertThat(stringCalculator.calculate("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11,3", "3:2,1,4:4"})
    void 올바른_덧셈식_입력(String input) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(14);
    }

    @Test
    void 커스텀_구분자가_존재하는_문자열_입력() {
        assertThat(stringCalculator.calculate("//;\\n1;2,3")).isEqualTo(6);
        assertThat(stringCalculator.calculate("//!\\n1,2!3!4")).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//?!@\n1;2,3", "//;!\n1;2;3"})
    void 많은_커스텀_구분자_입력(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2,3", "/;\n1;2;3", "//;1;2;3"})
    void 잘못된_딜리미터_입력(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input)).isInstanceOf(RuntimeException.class);
    }


    @Test
    void 숫자_이외의_타입_입력() {
        assertThatThrownBy(
            () -> stringCalculator.calculate("//;\\n1:a,3"))
            .isInstanceOf(RuntimeException.class
            );
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(
            () -> stringCalculator.calculate("-3,2:1"))
            .isInstanceOf(RuntimeException.class
            );
    }

    @Test
    void 소수_입력() {
        assertThatThrownBy(
            () -> stringCalculator.calculate("0.5,1.2:2"))
            .isInstanceOf(RuntimeException.class
            );
    }
}
