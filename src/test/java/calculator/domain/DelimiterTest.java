package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterTest {
    @ParameterizedTest
    @MethodSource("createDelimiterAndInput")
    void defineDelimiter(String input, String delimiter) {
        assertThat(new Delimiter(input).getDelimiter()).isEqualTo(delimiter);
    }

    private static Stream<Arguments> createDelimiterAndInput() {
        String customDelimiter = "a";

        return Stream.of(
                Arguments.of("1,2:3", Delimiter.DEFAULT_DELIMITER),
                Arguments.of("//" + customDelimiter + "\n1a2a3a", customDelimiter)
        );
    }

    @Test
    void hasCustomDelimiterTest() {
        //given
        String input = "//,\n";
        //then
        assertThat(new Delimiter(input).hasCustomDelimiter(input)).isTrue();
    }
}