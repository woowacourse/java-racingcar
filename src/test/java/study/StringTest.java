package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split_string() {
        String[] values = "1,2".split(",");
        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
        assertThat(values).containsExactly("1","2");
    }

    @Test
    void substringParentheses_string() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("test string index")
    void charAt_char() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("test index out of range")
    void charAt_indexOutOfBoundsException() {
        String value = "abc";
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
              .hasMessageContaining("String index out of range: 3");
    }
}
