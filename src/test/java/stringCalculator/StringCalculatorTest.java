package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void 쉼표를_기준으로_구분() {
        final int result = stringCalculator.calculateString("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론를_기준으로_구분() {
        final int result = stringCalculator.calculateString("1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자를_기준으로_구분() {
        String str = "//a\n2a3a4";
        final int result = stringCalculator.calculateString(str);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void split() {
        String str = "//a\n2a3a4";
        String[] splitValues = str.split("\n");
        assertThat(splitValues).contains("//a", "2a3a4");
    }

    @Test
    void 파라미터가_숫자가_아닌경우() {
        String str = "1,2,a";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_앞에_아무것도_없는경우() {
        String str = ",,1,2";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_뒤에_아무것도_없는경우() {
        String str = "1,2,,,";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_중간에_아무것도_없는경우() {
        String str = "1,;2";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_뒤에_아무것도_없는경우_커스텀구분자_포함() {
        String str = "\\!\n1,2!!";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구분자_중간에_아무것도_없는경우_커스텀구분자_포함() {
        String str = "\\!\n1!!2";
        assertThatThrownBy(() -> stringCalculator.calculateString(str))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 빈문자_입력() {
        final int result = stringCalculator.calculateString("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void null_입력() {
        final int result = stringCalculator.calculateString(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자1개_입력_1() {
        final int result = stringCalculator.calculateString("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 숫자1개_입력_2() {
        final int result = stringCalculator.calculateString("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> stringCalculator.calculateString("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
