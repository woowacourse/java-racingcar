package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String input = "abc";
        char character = input.charAt(1);
        assertThat(character).isEqualTo('b');

        assertThatThrownBy(() -> {
            String text = "ab";
            text.charAt(text.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
