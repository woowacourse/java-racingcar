package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;

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

    @Test
    void 문자열_배열을_숫자_배열로_변환() {
        List<Integer> actual = StringCalculator.convertToIntegerArray(new String[]{"1", "2", "3"});
        List<Integer> expected = Arrays.asList(1, 2, 3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자_이외의_값을_입력한_경우_예외처리() {
        assertThatThrownBy(() ->
                StringCalculator.convertToIntegerArray(new String[]{"a", "b"}))
                .isInstanceOf(RuntimeException.class);
    }
}
