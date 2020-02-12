package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    @DisplayName("문자열 파싱")
    void parse() {
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2:3";

        List<Integer> expected1 = Arrays.asList(new Integer[]{0});
        List<Integer> expected2 = Arrays.asList(new Integer[]{1, 2});
        List<Integer> expected3 = Arrays.asList(new Integer[]{1, 2, 3});

        List<Integer> result1 = StringParser.parse(input1);
        List<Integer> result2 = StringParser.parse(input2);
        List<Integer> result3 = StringParser.parse(input3);

        parseOneCase(input1, expected1, result1);
        parseOneCase(input2, expected2, result2);
        parseOneCase(input3, expected3, result3);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 파싱")
    void parse_WithCustomDelimiter() {
        String input = "//;\\n1;2;3";
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3});
        List<Integer> result = StringParser.parse(input);

        parseOneCase(input, expected, result);
    }

    private void parseOneCase(String input, List<Integer> expected, List<Integer> result) {
        assertThat(expected.equals(result)).isEqualTo(true);
    }

    @Test
    @DisplayName("음수와 숫자가 아닌 경우 예외 처리")
    void parse_ShouldGenerateExceptionWhenInputNegativeOrNonDigit() {
        Assertions.assertThatThrownBy(() -> {
            String input = "//;\\n1;a;3";
            List<Integer> result = StringParser.parse(input);
        }).isInstanceOf(RuntimeException.class);

        Assertions.assertThatThrownBy(() -> {
            String input = "//;\\n1;-2;3";
            List<Integer> result = StringParser.parse(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
