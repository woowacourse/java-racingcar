package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 콤마_구분자() {
        String[] actual = StringCalculator.splitString("1,2");
        String[] expected = {"1", "2"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 콜론_구분자() {
        String[] actual = StringCalculator.splitString("1:2");
        String[] expected = {"1", "2"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자() {
        String[] actual = StringCalculator.splitString("//;\n1;2;3");
        String[] expected = {"1", "2", "3"};

        assertThat(actual).isEqualTo(expected);
    }

}
