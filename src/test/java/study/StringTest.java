package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2:1,2", "1"}, delimiter = ':')
    @DisplayName("문자열 스플릿 테스트")
    void split1() {
        String input = "1,2";
        String[] actual = input.split(",");

        assertThat(actual).contains("1", "2");

    }

    @Test
    @DisplayName("문자열 스플릿 테스트")
    void split2() {
        String input = "1,";
        String[] actual = input.split(",");

        assertThat(actual).containsExactly("1");
    }

}
