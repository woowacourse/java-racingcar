package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("숫자 하나만 입력한 경우 해당 숫자 반환")
    void singleInput() {
        int actual = StringCalculator.splitAndSum("15");
        int expected = 15;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자에 여러 문자가 포함된 경우")
    void severalCharactersOnCustom() {
        int actual = StringCalculator.splitAndSum("//@@..\n5@@..6@@..4");
        int expected = 15;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자만 입력한 경우 예외처리")
    void onlySplitterInputException() {
        int actual = StringCalculator.splitAndSum(",");
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자만 입력한 경우 예외처리")
    void onlyCustomSplitterInputException() {
        int actual = StringCalculator.splitAndSum("//\n");
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("빈 문자열 입력한 경우 예외처리")
    void blankInputException() {
        int actual = StringCalculator.splitAndSum("");
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("null 입력한 경우 예외처리")
    void nullInputException() {
        int actual = StringCalculator.splitAndSum(null);
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자가 포함된 경우 예외처리")
    void numbersOnCustomSplitterException() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//..2.\n1..2.4"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값을 입력한 경우 예외처리")
    void inputNotNumbersException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"a", "b"}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수를 입력한 경우 예외처리")
    void inputNegativeNumberException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"-1", "-2"}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("소수값을 입력한 경우 예외처리")
    void inputDecimalException() {
        assertThatThrownBy(() -> StringCalculator.convertToIntegerArray(new String[]{"1.1", "2.3"}))
                .isInstanceOf(RuntimeException.class);
    }
}
