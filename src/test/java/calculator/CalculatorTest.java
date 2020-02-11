package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 구분자가_쉼표인_경우_분리() {
        String[] result = Calculator.splitString("1,2,3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void 구분자가_콜론인_경우_분리() {
        String[] result = Calculator.splitString("1:2:3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void 구분자가_쉼표와_콜론인_경우_분리() {
        String[] result = Calculator.splitString("1,2:3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void 구분자가_커스텀인_경우_분리() {
        String[] result = Calculator.splitString("//;\n1;2;3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void 문자열_배열의_원소들을_덧셈계산() {
        String[] numbers = Calculator.splitString("//;\n1;2;3");
        int result = Calculator.calculate(numbers);
        assertThat(result).isEqualTo(6);
    }
}
