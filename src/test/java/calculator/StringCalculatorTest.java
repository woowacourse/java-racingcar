package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculatorTest {

    static Stream<Arguments> differentParams() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1:2", new String[]{"1", "2"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"})
        );
    }

    @ParameterizedTest
    @MethodSource("differentParams")
    @DisplayName("다양한 구분자")
    void splitByParams(String given, String[] expected) {
        String[] actual = StringCalculator.splitString(given);
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
