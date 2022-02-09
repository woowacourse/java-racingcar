package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitByComma() {
        String input = "1,2";
        String[] splitResult = input.split(",");

        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
        assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    void splitByCommaWithoutComma() {
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void substringRemoveParenthesis() {
        String input = "(1,2)";
        String substringResult = input.substring(1,4);

        assertThat(substringResult).isEqualTo("1,2");
    }
}
