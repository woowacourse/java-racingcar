import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 덧셈_쉼표_두개의인자_여러입력확인() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);

        result = StringCalculator.add("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 덧셈_콜론_두개의인자_여러입력확인() {
        int result = StringCalculator.add("1:2");
        assertThat(result).isEqualTo(3);

        result = StringCalculator.add("4:5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 덧셈_인자가없을때() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 덧셈_쉼표_세개의인자() {
        int result = StringCalculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈_콜론_세개의인자() {
        int result = StringCalculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈_쉼표와_콜론_구분자가_같이_있고_세개의_인자가_있을_때() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }
}
