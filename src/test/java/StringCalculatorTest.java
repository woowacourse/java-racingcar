import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
    @Test
    void 덧셈_쉼표_두개의인자_여러입력확인() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);

        stringCalculator = new StringCalculator();
        result = stringCalculator.add("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 덧셈_콜론_두개의인자_여러입력확인() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1:2");
        assertThat(result).isEqualTo(3);

        stringCalculator = new StringCalculator();
        result = stringCalculator.add("4:5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 덧셈_인자가없을때() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 덧셈_쉼표_세개의인자() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈_콜론_세개의인자() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈_쉼표와_콜론_구분자가_같이_있고_세개의_인자가_있을_때() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);

        stringCalculator = new StringCalculator();
        result = stringCalculator.add("1,2:3:4,5");
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 덧셈_숫자_이외의_값이_들어갔을_때() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.add("haha"));
    }

    @Test
    void 덧셈_음수의_값이_들어갔을_때() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.add("-1"));
    }

    @Test
    void 덧셈_커스텀구분자가_있을_때() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
