package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;

public class StringCalculatorTest {

    @Test
    @DisplayName("콤마 구분자")
    void splitByComma() {
        String[] actual = StringCalculator.splitString("1,2");
        String[] expected = {"1", "2"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("콜론 구분자")
    void splitByColon() {
        String[] actual = StringCalculator.splitString("1:2");
        String[] expected = {"1", "2"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자")
    void splitByCustom() {
        String[] actual = StringCalculator.splitString("//;\n1;2;3");
        String[] expected = {"1", "2", "3"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 배열을 숫자 배열로 변환")
    void covertStringArrayToIntegerArray() {
        List<Integer> actual = StringCalculator.convertToIntegerArray(new String[]{"1", "2", "3"});
        List<Integer> expected = Arrays.asList(1, 2, 3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 배열 더하기")
    void sumIntegerArray() {
        int actual = StringCalculator.splitAndSum("1,2,3,4");
        int expected = 10;

        assertThat(actual).isEqualTo(expected);
    }
}
