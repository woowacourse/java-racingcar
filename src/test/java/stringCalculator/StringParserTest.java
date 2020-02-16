package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2e1,2", "1,2:3e1,2,3", "1,2:3:4e1,2,3,4"}, delimiter = 'e')
    @DisplayName("문자열 파싱")
    void parse(String input, String expected) {
        List<Integer> comparison = Arrays.stream(expected.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
        List<Integer> result = StringParser.parse(input);

        Assertions.assertThat(result.size() == comparison.size())
                .isTrue();
        Assertions.assertThat(result.containsAll(comparison))
                .isTrue();
    }

    @Test
    void parse_WhenInputIsBlank() {
        List<Integer> result = StringParser.parse("");
        Assertions.assertThat(result.size() == 1)
                .isTrue();
        Assertions.assertThat(result.get(0) == 0)
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3e1,2,3", "//bb\\n1bb2bb3,4e1,2,3,4"}, delimiter = 'e')
    @DisplayName("커스텀 구분자로 문자열 파싱")
    void parse_WithCustomDelimiter(String input, String expected) {
        List<Integer> comparison = Arrays.stream(expected.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
        List<Integer> result = StringParser.parse(input);

        Assertions.assertThat(comparison.size() == result.size())
                .isTrue();
        Assertions.assertThat(comparison.containsAll(result));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;a;3", "//;\\n1;-2;3"})
    @DisplayName("음수와 숫자가 아닌 경우 예외 처리")
    void parse_WhenInputNegativeOrNonDigit(String input) {
        Assertions.assertThatThrownBy(() -> {
            List<Integer> result = StringParser.parse(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
