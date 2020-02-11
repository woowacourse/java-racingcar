package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringParserTest {
    @Test
    @DisplayName("문자열 파싱")
    void parse() {
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2:3";

        List<String> expected1 = Arrays.asList(new String[]{""});
        List<String> expected2 = Arrays.asList(new String[]{"1","2"});
        List<String> expected3 = Arrays.asList(new String[]{"1","2","3"});

        List<String> result1 = StringParser.parse(input1);
        List<String> result2 = StringParser.parse(input2);
        List<String> result3 = StringParser.parse(input3);

        parseOneCase(input1, expected1, result1);
        parseOneCase(input2, expected2, result2);
        parseOneCase(input3, expected3, result3);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 파싱")
    void parse_WithCustomDelimiter() {
        String input = "//;\\n1;2;3";
        List<String> expected = Arrays.asList(new String[]{"1", "2", "3"});
        List<String> result = StringParser.parse(input);

        parseOneCase(input, expected, result);
    }

    private void parseOneCase(String input, List<String> expected, List<String> result) {
        assertThat(expected.equals(result)).isEqualTo(true);
    }

}
